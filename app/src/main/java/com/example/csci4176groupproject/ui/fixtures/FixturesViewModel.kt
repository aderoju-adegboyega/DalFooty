package com.example.csci4176groupproject.ui.fixtures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FixturesViewModel : ViewModel() {
    private val _fixtures = MutableLiveData<List<Fixture>>().apply {
        value = emptyList()
    }
    val fixtures: LiveData<List<Fixture>> = _fixtures

    fun setFixtures(fixtures: List<Fixture>) {
        _fixtures.value = fixtures
    }
}