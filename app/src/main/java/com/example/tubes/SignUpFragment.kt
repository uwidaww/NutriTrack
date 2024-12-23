package com.example.tubes

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class SignUpFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnSignUp: Button = view.findViewById(R.id.buttonDaftar)
        btnSignUp.setOnClickListener {
            val name = view.findViewById<EditText>(R.id.usernameSignUp).text.toString()
            val password = view.findViewById<EditText>(R.id.passSignUp).text.toString()
            val konfpass = view.findViewById<EditText>(R.id.konfirPassSignUp).text.toString()


            // Navigate to Questionnaire

        }
    }
}
