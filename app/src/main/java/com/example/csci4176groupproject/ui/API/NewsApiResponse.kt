package com.example.csci4176groupproject.ui.API

import com.example.csci4176groupproject.ui.news.Article

data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)


