package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class introductionApp : Fragment() {
    private lateinit var aturRencana: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_introduction_app, container, false)

        aturRencana = view.findViewById(R.id.buttonAturRencana)

        aturRencana.setOnClickListener {
            (activity as MainActivity).loadFragment(pertanyaanSatu())
        }
        return view
    }

}