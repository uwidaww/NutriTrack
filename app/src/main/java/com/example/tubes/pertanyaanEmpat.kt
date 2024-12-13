package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Toast

private lateinit var makan: RadioGroup
private lateinit var konsumsi: RadioGroup
private lateinit var camilan: RadioGroup
private lateinit var selanjutnya: Button
private lateinit var kembali: ImageButton
private lateinit var karbo: CheckBox
private lateinit var protein: CheckBox
private lateinit var lemak: CheckBox
private lateinit var seimbang: CheckBox

class pertanyaanEmpat : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pertanyaan_empat, container, false)

        makan = view.findViewById(R.id.rbGroupMakan)
        konsumsi = view.findViewById(R.id.rbInstan)
        camilan = view.findViewById(R.id.rbNyemil)
        kembali = view.findViewById(R.id.buttonBackEmpat)
        selanjutnya = view.findViewById(R.id.buttonSelesaiPertanyaan)
        karbo = view.findViewById(R.id.cbKarbo)
        protein = view.findViewById(R.id.cbProtein)
        lemak = view.findViewById(R.id.cbLemak)
        seimbang = view.findViewById(R.id.cbSeimbang)

        selanjutnya.setOnClickListener {
            val rbGroupMakan = makan.checkedRadioButtonId
            val rbInstan = konsumsi.checkedRadioButtonId
            val rbNyemil = camilan.checkedRadioButtonId
            val isCheckboxChecked = karbo.isChecked || protein.isChecked || lemak.isChecked || seimbang.isChecked

            when {
                rbGroupMakan == -1 || rbInstan == -1 || rbNyemil == 1 -> {
                    Toast.makeText(requireContext(), "Isi semua detail", Toast.LENGTH_SHORT).show()
                }
                !isCheckboxChecked -> {
                    Toast.makeText(
                    requireContext(),
                    "Pilih minimal satu jenis makanan",
                    Toast.LENGTH_SHORT
                ).show()
            }
                else -> {
                    (activity as MainActivity).loadFragment(resultPertanyaan())
                }
            }
        }
        kembali.setOnClickListener {
            // Optionally, you can handle the back navigation here
            (activity as MainActivity).loadFragment(pertanyaanTiga()) // Or load the previous fragment
        }
        return view
    }
}