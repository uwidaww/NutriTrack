package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

private lateinit var keluar: ImageButton

class changePassword : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_change_password, container, false)
        keluar = view.findViewById(R.id.buttonBackChangePass)

        keluar.setOnClickListener {
            (activity as MainActivity).loadFragment(settingsFragment())
        }
        return view
    }
}