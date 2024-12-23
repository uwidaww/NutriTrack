package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast

private lateinit var olahraga: RadioGroup
private lateinit var aktivitas: RadioGroup
private lateinit var spinner: Spinner
private lateinit var durasi: RadioGroup
private lateinit var pekerjaan: RadioGroup
private lateinit var selanjutnya: Button
private lateinit var kembali: ImageButton


class pertanyaanTiga : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pertanyaan_tiga, container, false)

        olahraga = view.findViewById(R.id.rbAktifOlahraga)
        aktivitas = view.findViewById(R.id.rbWaktuOlahraga)
        durasi = view.findViewById(R.id.rbDurasiOlahraga)
        pekerjaan = view.findViewById(R.id.rbAktivitasOlahraga)
        selanjutnya = view.findViewById(R.id.buttonNextPertanyaanTiga)
        kembali = view.findViewById(R.id.buttonBackTiga)

        spinner = view.findViewById(R.id.jenisOlahraga)
        ArrayAdapter.createFromResource(
            requireContext(), // Use requireContext() instead of this
            R.array.olahraga_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }

        selanjutnya.setOnClickListener {
            val rbAktifOlahraga = olahraga.checkedRadioButtonId
            val rbWaktuOlahraga = aktivitas.checkedRadioButtonId
            val rbDurasiOlahraga = durasi.checkedRadioButtonId
            val rbAktivitasOlahraga = pekerjaan.checkedRadioButtonId


            val aktifButtonText = when (olahraga.checkedRadioButtonId) {
                R.id.rbKurang -> "Tidak aktif (kurang dari 2.000 langkah)"
                R.id.rbCukup -> "Cukup aktif (2.000–5.000 langkah)"
                else -> "Sangat aktif (lebih dari 5.000 langkah)"
            }

            val durasiButtonText = when (durasi.checkedRadioButtonId) {

                R.id.rbKurangDurasi -> "Kurang dari 30 menit"
                R.id.rbCukupDurasi -> "30–60 menit"
                else -> "Lebih dari 60 menit"
            }

            val waktuButtonText = when (aktivitas.checkedRadioButtonId){

                R.id.rbTidakPernah -> "Tidak Pernah"
                R.id.rbSekali -> "1-2 kali"
                R.id.rbTigakali -> "3-4 kali"
                else -> "5 kali atau lebih"

            }

            when {
                rbAktifOlahraga == -1 || rbWaktuOlahraga == -1 || rbDurasiOlahraga == 1 || rbAktivitasOlahraga == 1 -> {
                    Toast.makeText(requireContext(), "Isi semua detail", Toast.LENGTH_SHORT).show()
                }

                else -> {
<<<<<<< HEAD
<<<<<<< HEAD
                    var Data = promptData()
                    Data.setAktivitasHarian(aktifButtonText)
                    Data.setBanyakOlahraga(waktuButtonText)
                    Data.setDurasiOlahraga(durasiButtonText)
=======
>>>>>>> e45f3ac069c493400b412bad687471cdb7182e4c
=======
>>>>>>> e45f3ac069c493400b412bad687471cdb7182e4c
                    (activity as MainActivity).loadFragment(pertanyaanEmpat())
                }
            }
        }
        kembali.setOnClickListener {
            // Optionally, you can handle the back navigation here
            (activity as MainActivity).loadFragment(pertanyaanDua()) // Or load the previous fragment
        }
        return view
    }
}