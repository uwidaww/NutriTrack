package com.example.tubes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressViewModel : ViewModel() {
    private val _progress = MutableLiveData<Float>()
    val progress: LiveData<Float> get() = _progress

    fun setProgress(value: Float) {
        _progress.value = value
    }
}