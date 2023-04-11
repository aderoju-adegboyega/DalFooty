package com.example.csci4176groupproject.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {

    private val _news = MutableLiveData<List<Article>>().apply {
        value = emptyList()
    }
    val news: LiveData<List<Article>> = _news

    fun setNews(news: List<Article>) {
        _news.value = news
    }
}