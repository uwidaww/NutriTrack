package com.example.tubes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import com.example.tubes.R

class tampilanHidrasi : Fragment() {
    private lateinit var keluar: ImageButton
    private lateinit var resetButton: ImageButton
    private lateinit var doneButton: ImageButton
    private var currentProgress: Float = 0f // Track current progress
    private var isDone: Boolean = false // Track if the progress is done

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tampilan_hidrasi, container, false)

        keluar = view.findViewById(R.id.buttonBack)
        resetButton = view.findViewById(R.id.reset)
        doneButton = view.findViewById(R.id.button_done)

        val circularProgressBar = view.findViewById<CircularProgressBar>(R.id.circularprogressHidrasi)

        // Configure the CircularProgressBar
        circularProgressBar.apply {
            progressMax = 1000f
            setProgressWithAnimation(currentProgress, 1000) // Set initial progress
            progressBarWidth = 5f
            backgroundProgressBarWidth = 7f
            progressBarColor = ContextCompat.getColor(requireContext(), R.color.purple)
        }

        // Set up button click listeners
        view.findViewById<Button>(R.id.button100ml).setOnClickListener {
            updateProgress(100f, circularProgressBar)
        }
        view.findViewById<Button>(R.id.button250ml).setOnClickListener {
            updateProgress(250f, circularProgressBar)
        }
        view.findViewById<Button>(R.id.button500ml).setOnClickListener {
            updateProgress(500f, circularProgressBar)
        }
        view.findViewById<Button>(R.id.button1l).setOnClickListener {
            updateProgress(1000f, circularProgressBar)
        }

        keluar.setOnClickListener {
            (activity as MainActivity).loadFragment(berandaFragment())
        }

        // Reset button click listener
        resetButton.setOnClickListener {
            resetProgress(circularProgressBar)
        }

        // Done button click listener
        doneButton.setOnClickListener {
            isDone = true // Mark progress as done
        }

        return view
    }

    private fun updateProgress(amount: Float, circularProgressBar: CircularProgressBar) {
        if (isDone) return // Prevent updates if done

        // Update the current progress
        currentProgress += amount
        if (currentProgress > 1000f) {
            currentProgress = 1000f // Cap the progress at 1000
        }
        // Log the current progress for debugging
        Log.d("tampilanHidrasi", "Current Progress: $currentProgress")
        // Update the CircularProgressBar with animation
        circularProgressBar.setProgressWithAnimation(currentProgress, 1000)
    }

    private fun resetProgress(circularProgressBar: CircularProgressBar) {
        currentProgress = 0f // Reset progress
        isDone = false // Allow updates again
        circularProgressBar.setProgressWithAnimation(currentProgress, 1000) // Reset the CircularProgressBar
        Log.d("tampilanHidrasi", "Progress reset to: $currentProgress")
    }
}