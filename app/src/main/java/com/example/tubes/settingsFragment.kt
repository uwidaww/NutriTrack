package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

private lateinit var profile: ImageButton
private lateinit var target: ImageButton
private lateinit var ubahPass: ImageButton
private lateinit var keluar: ImageButton

class settingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_settings, container, false)

        profile = view.findViewById(R.id.masukAkun)
        target = view.findViewById(R.id.masukTargetSaya)
        ubahPass = view.findViewById(R.id.masukUbahPass)
        keluar = view.findViewById(R.id.keluarAplikasi)

        profile.setOnClickListener{
            (activity as MainActivity).loadFragment(account())
        }
        target.setOnClickListener{
            (activity as MainActivity).loadFragment(targetSaya())
        }
        ubahPass.setOnClickListener{
            (activity as MainActivity).loadFragment(changePassword())
        }
        keluar.setOnClickListener{
            (activity as MainActivity).loadFragment(signIn())
        }
        return view
    }
}