package com.example.tubes

import android.os.Bundle
import android.view.*
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.collections.ArrayList
import com.example.tubes.dataClassRv

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigation)

        // Load the SignIn fragment first
        loadFragment(signIn())

        // Set up the bottom navigation listener
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navHome -> {
                    loadFragment(berandaFragment())
                    true
                }
                R.id.navResep -> {
                    loadFragment(resepFragment())
                    true
                }
//                R.id.navAlarm -> {
//                    loadFragment(berandaFragment())
//                    true
//                }
                R.id.navPengaturan -> {
                    loadFragment(settingsFragment())
                    true
                }
                else -> false
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }




    fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()

        // Show or hide the BottomNavigationView based on the fragment
        if (fragment is signIn || fragment is signUp || fragment is introductionApp || fragment is pertanyaanSatu || fragment is pertanyaanDua ||
            fragment is pertanyaanTiga || fragment is pertanyaanEmpat || fragment is resultPertanyaan || fragment is tampilanActivity ||
            fragment is tampilanEvaluasi || fragment is tampilanRasio || fragment is tampilanHidrasi || fragment is account
            || fragment is targetSaya || fragment is changePassword) {
            bottomNavigationView.visibility = View.GONE // Hide BottomNavigationView
        } else {
            bottomNavigationView.visibility = View.VISIBLE // Show BottomNavigationView
        }
    }
}