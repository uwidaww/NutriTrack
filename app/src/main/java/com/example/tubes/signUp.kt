package com.example.tubes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class signUp : Fragment() {
    private lateinit var namaPengguna: TextView
    private lateinit var kataSandi: TextView
    private lateinit var konfirKataSandi: TextView
    private lateinit var linkMasuk: TextView
    private lateinit var daftar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        // Initialize views
        namaPengguna = view.findViewById(R.id.usernameSignUp)
        kataSandi = view.findViewById(R.id.passSignUp)
        konfirKataSandi = view.findViewById(R.id.konfirPassSignUp)
        linkMasuk = view.findViewById(R.id.masuk)
        daftar = view.findViewById(R.id.buttonDaftar)

        // Set click listeners
        daftar.setOnClickListener {
            val username = namaPengguna.text.toString()
            val password = kataSandi.text.toString()
            val konifrPass = konfirKataSandi.text.toString()

            when {
                username.isEmpty() || password.isEmpty() || konifrPass.isEmpty() -> {
                    Toast.makeText(requireContext(), "Isi semua detail", Toast.LENGTH_SHORT).show()
                }

                password != konifrPass-> {
                Toast.makeText(requireContext(), "Kata sandi tidak cocok", Toast.LENGTH_SHORT)
                    .show()
                } else -> {

                Toast.makeText(requireContext(), "Berhasil daftar", Toast.LENGTH_SHORT).show()
                (activity as MainActivity).loadFragment(signIn())
            }
            }
        }

        linkMasuk.setOnClickListener {
            (activity as MainActivity).loadFragment(signIn())
        }

        return view
    }
}