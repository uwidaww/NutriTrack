package com.example.laststand

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.DialogFragment
import java.util.*


class ReminderDialogFragment(private val onSave: (AlarmModel) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.setalarm)

        // Referensi View
        val tvTimePicker: TextView = dialog.findViewById(R.id.Jam)
        val etReminderName: EditText = dialog.findViewById(R.id.etReminderName)
        val spinnerSound: Spinner = dialog.findViewById(R.id.spinnerSound)
        val btnOk: Button = dialog.findViewById(R.id.btnOk)
        val btnCancel: Button = dialog.findViewById(R.id.btnCancel)

        // Atur TimePicker
        val calendar = Calendar.getInstance()
        var selectedHour = calendar.get(Calendar.HOUR_OF_DAY)
        var selectedMinute = calendar.get(Calendar.MINUTE)

        tvTimePicker.text = String.format("%02d:%02d", selectedHour, selectedMinute)
        tvTimePicker.setOnClickListener {
            TimePickerDialog(
                requireContext(),
                { _, hourOfDay, minute ->
                    selectedHour = hourOfDay
                    selectedMinute = minute
                    tvTimePicker.text = String.format("%02d:%02d", hourOfDay, minute)
                },
                selectedHour,
                selectedMinute,
                true
            ).show()
        }

        // Spinner untuk Suara
        val sounds = arrayOf("Bounce", "Ping", "Beep")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, sounds)
        spinnerSound.adapter = adapter

        // Tombol OK dan Cancel
        btnOk.setOnClickListener {
            val name = etReminderName.text.toString()
            val days = listOf("Sen", "Rab", "Kam") // Hardcoded, bisa disesuaikan dari input UI
            val newAlarm = AlarmModel(selectedHour, selectedMinute, name, days, true)

            // Kirim data melalui onSave callback
            onSave(newAlarm)

            // Tampilkan toast untuk konfirmasi
            Toast.makeText(requireContext(), "Pengingat Disimpan!", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        btnCancel.setOnClickListener { dismiss() }

        return dialog
    }
}
