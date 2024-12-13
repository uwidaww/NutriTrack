package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Toast

private lateinit var minum: RadioGroup
private lateinit var kesulitan: RadioGroup
private lateinit var pengingat: RadioGroup
private lateinit var selanjutnya: Button
private lateinit var kembali: ImageButton


class pertanyaanDua : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_pertanyaan_dua, container, false)

        minum = view.findViewById(R.id.rbGroupBanyakMinum)
        kesulitan = view.findViewById(R.id.rbGroupSulitMinum)
        pengingat = view.findViewById(R.id.rbGroupReminderMinum)
        selanjutnya = view.findViewById(R.id.buttonNextPertanyaanDua)
        kembali = view.findViewById(R.id.buttonBackDua)

        selanjutnya.setOnClickListener {
            val rbGroupBanyakMinum = minum.checkedRadioButtonId
            val rbGroupSulitMinum = kesulitan.checkedRadioButtonId
            val rbGroupReminderMinum = pengingat.checkedRadioButtonId

            when {
                rbGroupBanyakMinum == -1 || rbGroupSulitMinum == -1 || rbGroupReminderMinum == 1 -> {
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