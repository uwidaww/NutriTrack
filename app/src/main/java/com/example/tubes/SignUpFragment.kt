package com.example.tubes

import DatabaseHelper
import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class SignUpFragment : Fragment() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHelper = DatabaseHelper(requireContext())

        val btnSignUp: Button = view.findViewById(R.id.buttonDaftar)
        btnSignUp.setOnClickListener {
            val name = view.findViewById<EditText>(R.id.usernameSignUp).text.toString()
            val password = view.findViewById<EditText>(R.id.passSignUp).text.toString()
            val konfpass = view.findViewById<EditText>(R.id.konfirPassSignUp).text.toString()

            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(DatabaseHelper.COLUMN_USER_NAME, name)
                put(DatabaseHelper.COLUMN_USER_EMAIL, password)
                put(DatabaseHelper.COLUMN_USER_PASSWORD, konfpass)
            }

            db.insert(DatabaseHelper.TABLE_USER, null, values)

            // Navigate to Questionnaire

        }
    }
}
