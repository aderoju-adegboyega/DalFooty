package com.example.csci4176groupproject.ui.fixtures

import com.google.gson.annotations.SerializedName

data class Fixture(
    @SerializedName("home_name")
    val home_name: String,
    @SerializedName("away_name")
    val away_name: String,
    @SerializedName("date")
    val date: String
)