package com.example.csci4176groupproject.ui.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LiveScoreRetrofitInstance {
    private const val BASE_URL = "https://livescore-api.com/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: LiveScoreApiService by lazy {
        retrofit.create(LiveScoreApiService::class.java)
    }
}
