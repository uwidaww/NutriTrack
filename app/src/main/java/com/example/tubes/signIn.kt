package com.example.tubes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class signIn : Fragment() {
    private lateinit var namaPengguna: TextView
    private lateinit var kataSandi: TextView
    private lateinit var linkDaftar: TextView
    private lateinit var login: Button
    val firestoreDatabase = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        // Initialize views
        namaPengguna = view.findViewById(R.id.usernameSignIn)
        kataSandi = view.findViewById(R.id.passSignIn)
        linkDaftar = view.findViewById(R.id.daftar)
        login = view.findViewById(R.id.buttonLoginSignIn)

        // Set click listeners
        login.setOnClickListener {
            val username = namaPengguna.text.toString()
            val password = kataSandi.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Isi semua detail", Toast.LENGTH_SHORT).show()
            } else {
                firestoreDatabase.collection("user")
                    .get()
                    .addOnCompleteListener {
                        val resus = ""
                        val respass = ""
                        if (it.isSuccessful){
                            for(doc in it.result) {
                                val resus = doc.get("name")
                                val respass = doc.get("pass")

                                if (resus == username && respass == password){
                                    Toast.makeText(requireContext(), "Berhasil masuk", Toast.LENGTH_SHORT).show()
                                    (activity as MainActivity).loadFragment(introductionApp())
                                    break
                                }
                            }
                        }
                    }


            }
        }

        linkDaftar.setOnClickListener {
            (activity as MainActivity).loadFragment(signUp())
        }
        return view
    }
}