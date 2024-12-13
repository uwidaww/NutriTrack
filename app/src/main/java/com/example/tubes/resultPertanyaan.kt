package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

private lateinit var selanjutnya: Button
private lateinit var kembali: Button

class resultPertanyaan : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result_pertanyaan, container, false)
        kembali = view.findViewById(R.id.button_backHasil)
        selanjutnya = view.findViewById(R.id.button_nextHasil)

        selanjutnya.setOnClickListener {
            (activity as MainActivity).loadFragment(berandaFragment())
        }
        kembali.setOnClickListener {
            (activity as MainActivity).loadFragment(pertanyaanSatu())
        }
        return view
    }
}