package com.example.zapzapventure.ui.Settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConfViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Settings"
    }
    val text: LiveData<String> = _text

}