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

            when {
                rbAktifOlahraga == -1 || rbWaktuOlahraga == -1 || rbDurasiOlahraga == 1 || rbAktivitasOlahraga == 1 -> {
                    Toast.makeText(requireContext(), "Isi semua detail", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    (activity as MainActivity).loadFragment(pertanyaanTiga())
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