package com.example.csci4176groupproject.ui.home

import com.google.gson.annotations.SerializedName

data class HomeArticle (
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)