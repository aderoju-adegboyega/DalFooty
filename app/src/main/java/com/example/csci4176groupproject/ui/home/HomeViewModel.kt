package com.example.csci4176groupproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.csci4176groupproject.ui.news.Article

class HomeViewModel : ViewModel() {

    private val _homeNews = MutableLiveData<List<Article>>().apply {
        value = emptyList()
    }
    val homeNews: LiveData<List<Article>> = _homeNews

    fun setHomeNews(news: List<Article>) {
        _homeNews.value = news
    }
}