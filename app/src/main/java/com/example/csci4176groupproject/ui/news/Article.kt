package com.example.csci4176groupproject.ui.news

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)