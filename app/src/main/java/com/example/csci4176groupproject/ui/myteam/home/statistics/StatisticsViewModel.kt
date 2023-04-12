package com.example.csci4176groupproject.ui.myteam.home.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StatisticsViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Statistics Fragment"
    }
    val text: LiveData<String> = _text
}