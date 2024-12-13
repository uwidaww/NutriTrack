package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton

private lateinit var keluar: ImageButton
private lateinit var ulangTarget: Button
class targetSaya : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_target_saya, container, false)

        keluar = view.findViewById(R.id.buttonBackTarget)
        ulangTarget = view.findViewById(R.id.buttonAturUlangTarget)

        keluar.setOnClickListener {
            (activity as MainActivity).loadFragment(settingsFragment())
        }
        ulangTarget.setOnClickListener {
            (activity as MainActivity).loadFragment(pertanyaanSatu())
        }
        return view
    }
}