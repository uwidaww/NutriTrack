package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class tampilanRasio : Fragment() {
    private lateinit var keluar: ImageButton
    private lateinit var progressTextView: TextView // Reference to the TextView
    private var currentProgress: Float = 0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tampilan_rasio, container, false)

        keluar = view.findViewById(R.id.buttonBack)
        progressTextView = view.findViewById(R.id.kalori)
        val circularProgressBar = view.findViewById<CircularProgressBar>(R.id.circularprogressrasio)

        // Configure the CircularProgressBar
        circularProgressBar.apply {
            progressMax = 1500f
            setProgressWithAnimation(700f, 1000) // Set initial progress to 700 with animation over 1 second
            progressBarWidth = 5f // Set the width of the progress bar
            backgroundProgressBarWidth = 7f // Set the width of the background progress bar
            progressBarColor = ContextCompat.getColor(requireContext(), R.color.purple) // Use a color resource
        }

        keluar.setOnClickListener {
            (activity as MainActivity).loadFragment(berandaFragment())
        }

        // Update the TextView to show the current progress
        updateProgressText(700f)

        return view
    }
    private fun updateProgressText(progress: Float) {
        // Update the TextView to show the current progress
        progressTextView.text = "Konsumsi\n${progress.toInt()} kalori"
    }
}