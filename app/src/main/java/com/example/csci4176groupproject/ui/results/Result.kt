package com.example.csci4176groupproject.ui.results

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("home_name")
    val homeName: String,
    @SerializedName("away_name")
    val awayName: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("date")
    val date: String
)