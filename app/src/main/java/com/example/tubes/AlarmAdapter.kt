package com.example.tubes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laststand.databinding.ItemAlarmBinding

class AlarmAdapter(
    private val alarmList: List<AlarmModel>,
    private val onToggle: (AlarmModel) -> Unit
) : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {

    inner class AlarmViewHolder(private val binding: ItemAlarmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(alarm: AlarmModel) {
            with(binding) {
                txtTime.text = String.format("%02d:%02d", alarm.hour, alarm.minute)
                txtName.text = alarm.name
                txtDays.text = alarm.days.joinToString(", ") { it }
                switchActive.isChecked = alarm.isActive

                switchActive.setOnCheckedChangeListener { _, isChecked ->
                    alarm.isActive = isChecked
                    onToggle(alarm)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val binding = ItemAlarmBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AlarmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(alarmList[position])
    }

    override fun getItemCount(): Int = alarmList.size
}
