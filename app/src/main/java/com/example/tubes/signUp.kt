package com.example.tubes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import java.lang.Integer.getInteger


class signUp : Fragment() {
    private lateinit var namaPengguna: TextView
    private lateinit var kataSandi: TextView
    private lateinit var konfirKataSandi: TextView
    private lateinit var linkMasuk: TextView
    private lateinit var bdaftar: Button

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
        bdaftar = view.findViewById(R.id.buttonDaftar)

        // Set click listeners
        bdaftar.setOnClickListener {
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


                val firestoreDatabasea = FirebaseFirestore.getInstance()
                var count : String = ""

                val saaa = firestoreDatabasea.collection("user").get().result.isEmpty






                    var newUser :MutableMap<String,Any> = HashMap()
                    newUser["ID"] = count
                    newUser["name"] = username
                    newUser["pass"] = password
                    newUser["gender"] = ""
                    newUser["BB"] = ""
                    newUser["TB"] = ""

                    val upCount:MutableMap<String,Any> = HashMap()
                    upCount["IDavailable"] = getInteger(count) + 1

                firestoreDatabasea.collection("user")
                    .add(newUser)
                    .addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(requireContext(), "Berhasil daftar", Toast.LENGTH_SHORT).show()
                            (activity as MainActivity).loadFragment(signIn())
                        }

                    }

                firestoreDatabasea.collection("user")
                    .get()
                    .addOnCompleteListener{
                        if (it.isSuccessful){
                            for(doc in it.result){
                                firestoreDatabasea.collection("user")
                                    .document("IDCounter")
                                    .set(upCount)
                                break
                            }
                        }
                    }

            }
            }
        }

        linkMasuk.setOnClickListener {
            (activity as MainActivity).loadFragment(signIn())
        }

        return view
    }
}