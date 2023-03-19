package com.example.csci4176groupproject.ui.fixtures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FixturesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Fixtures Fragment"
    }
    val text: LiveData<String> = _text
}