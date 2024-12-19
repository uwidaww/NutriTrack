package com.example.laststand

data class AlarmModel(
    val hour: Int,
    val minute: Int,
    val name: String,
    val days: List<String>,
    var isActive: Boolean
)