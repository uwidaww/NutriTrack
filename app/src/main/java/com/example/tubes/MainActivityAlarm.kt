package com.example.tubes

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laststand.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ReminderAdapter
    private val reminderList = mutableListOf<Reminder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        setupRecyclerView()

        // Referensi tombol tambah pengingat
        val btnAddReminder: ImageView = findViewById(R.id.btnAddReminder)
        btnAddReminder.setOnClickListener {
            val dialog = ReminderDialogFragment { reminder ->
                addReminder(reminder)
            }
            dialog.show(supportFragmentManager, "ReminderDialog")
        }
    }

    private fun setupRecyclerView() {
        adapter = ReminderAdapter(reminderList)
        binding.recyclerViewReminders.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewReminders.adapter = adapter
    }

    private fun addReminder(reminder: Reminder) {
        reminderList.add(reminder)
        adapter.notifyDataSetChanged()
    }



    // Kelas untuk Dialog Pengingat
    class ReminderDialogFragment(private val onSave: (Reminder) -> Unit) : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.setalarm)

            // Referensi View di dalam dialog
            val tvTimePicker: TextView = dialog.findViewById(R.id.Jam)
            val etReminderName: EditText = dialog.findViewById(R.id.etReminderName)
            val spinnerSound: Spinner = dialog.findViewById(R.id.spinnerSound)
            val btnOk: Button = dialog.findViewById(R.id.btnOk)
            val btnCancel: Button = dialog.findViewById(R.id.btnCancel)

            // TimePickerDialog untuk memilih waktu
            val calendar = Calendar.getInstance()
            tvTimePicker.text = String.format(
                "%02d:%02d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE)
            )

            tvTimePicker.setOnClickListener {
                TimePickerDialog(
                    requireContext(),
                    { _, hourOfDay, minute ->
                        tvTimePicker.text = String.format("%02d:%02d", hourOfDay, minute)
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true
                ).show()
            }

            // Spinner untuk suara pengingat
            val sounds = arrayOf("Bounce", "Ping", "Beep")
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, sounds)
            spinnerSound.adapter = adapter

            // Tombol OK dan Cancel
            btnOk.setOnClickListener {
                val reminderName = etReminderName.text.toString()
                val selectedTime = tvTimePicker.text.toString()
                val selectedSound = spinnerSound.selectedItem.toString()

                val reminder = Reminder(reminderName, selectedTime, selectedSound, true)
                onSave(reminder)
                dismiss()
            }

            btnCancel.setOnClickListener { dismiss() }

            return dialog
        }
    }
}

// Model data untuk Reminder
data class Reminder(
    val name: String,
    val time: String,
    val sound: String,
    var isActive: Boolean
)

// Adapter untuk RecyclerView
class ReminderAdapter(private val reminders: List<Reminder>) :
    RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder>() {

    inner class ReminderViewHolder(private val view: LinearLayout) :
        RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.etReminderName)
        val txtTime: TextView = view.findViewById(R.id.Jam)
        val txtSound: TextView = view.findViewById(R.id.spinnerSound)
        val switchActive: Switch = view.findViewById(R.id.switchActive)

        fun bind(reminder: Reminder) {
            txtName.text = reminder.name
            txtTime.text = reminder.time
            txtSound.text = reminder.sound
            switchActive.isChecked = reminder.isActive

            switchActive.setOnCheckedChangeListener { _, isChecked ->
                reminder.isActive = isChecked
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemalarm, parent, false) as LinearLayout
        return ReminderViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        holder.bind(reminders[position])
    }

    override fun getItemCount(): Int = reminders.size
}
