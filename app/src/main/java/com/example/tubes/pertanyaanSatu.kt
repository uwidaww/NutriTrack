package com.example.tubes

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class pertanyaanSatu : Fragment(), DatePickerDialog.OnDateSetListener {

    private var tanggal = 0
    private var bulan = 0
    private var tahun = 0

    private lateinit var namaLengkap: TextView
    private lateinit var tinggiBadan: TextView
    private lateinit var beratBadan: TextView
    private lateinit var gender: RadioGroup
    private lateinit var tujuan: RadioGroup
    private lateinit var selanjutnya: Button
    private lateinit var kembali: ImageButton
    private lateinit var teksTanggal: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pertanyaan_satu, container, false)

        namaLengkap = view.findViewById(R.id.namaCol)
        tinggiBadan = view.findViewById(R.id.tbCol)
        beratBadan = view.findViewById(R.id.bbCol)
        gender = view.findViewById(R.id.rbGroupGender)
        tujuan = view.findViewById(R.id.rbGroupTujuan)
        selanjutnya = view.findViewById(R.id.buttonNextPertanyaanSatu)
        kembali = view.findViewById(R.id.buttonBackSatu)
        teksTanggal = view.findViewById(R.id.tanggalCol)

        selanjutnya.setOnClickListener {
            val namaCol = namaLengkap.text.toString()
            val tbCol = tinggiBadan.text.toString()
            val bbCol = beratBadan.text.toString()
            val rbGroupGender = gender.checkedRadioButtonId
            val rbGroupTujuan = tujuan.checkedRadioButtonId

            when {
                namaCol.isEmpty() || tbCol.isEmpty() || bbCol.isEmpty() -> {
                    Toast.makeText(requireContext(), "Isi semua detail", Toast.LENGTH_SHORT).show()
                }

                rbGroupGender == -1 -> {
                    Toast.makeText(requireContext(), "Pilih jenis kelamin", Toast.LENGTH_SHORT).show()
                }
                rbGroupTujuan == -1 -> {
                    Toast.makeText(requireContext(), "Pilih tujuan Anda", Toast.LENGTH_SHORT).show()
                }else -> {
                    (activity as MainActivity).loadFragment(pertanyaanDua())
                }
            }
        }

        kembali.setOnClickListener {
            // Optionally, you can handle the back navigation here
            (activity as MainActivity).loadFragment(introductionApp()) // Or load the previous fragment
        }
        val imageButton: ImageButton = view.findViewById(R.id.imageButton)
        imageButton.setOnClickListener {
            fSetTanggal(view)
        }
        return view
    }
    private fun getSaatIni(){
        val kal: Calendar = Calendar.getInstance()
        tanggal = kal.get(Calendar.DAY_OF_MONTH)
        bulan = kal.get(Calendar.MONTH)
        tahun = kal.get(Calendar.YEAR)
    }
    private fun fSetTanggal(view: View){
        getSaatIni()
        DatePickerDialog(requireContext(), this, tahun, bulan, tanggal).show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        tanggal = dayOfMonth
        bulan = month +1
        tahun = year
        teksTanggal.text = "${tanggal} - ${bulan} - ${tahun}"
    }
}