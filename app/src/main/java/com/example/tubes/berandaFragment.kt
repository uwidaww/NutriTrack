package com.example.tubes

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.tubes.R
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class berandaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        val circularProgressBar = view.findViewById<CircularProgressBar>(R.id.circularprogress)

        // Configure the CircularProgressBar
        circularProgressBar.apply {
            progressMax = 100f
            setProgressWithAnimation(50f, 1000) // Set progress to 50 with animation over 1 second
            progressBarWidth = 5f // Set the width of the progress bar
            backgroundProgressBarWidth = 7f // Set the width of the background progress bar
            progressBarColor = ContextCompat.getColor(requireContext(), R.color.purple) // Use a color resource
        }

        // Find the ImageButton (or Button) and set a click listener
        val hidrasi = view.findViewById<ImageButton>(R.id.hidrasi)
        hidrasi.setOnClickListener {
            // Load the tampilanHidrasi fragment
            (activity as MainActivity).loadFragment(tampilanHidrasi())
        }

        return view
    }
}