package com.example.csci4176groupproject.ui.API

import com.example.csci4176groupproject.ui.fixtures.Fixture
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("data")
    val data: FixtureData
)

data class FixtureData(
    @SerializedName("fixtures")
    val fixtures: List<Fixture>
)