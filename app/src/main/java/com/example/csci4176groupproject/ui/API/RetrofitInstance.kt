package com.example.csci4176groupproject.ui.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val loggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private val retrofitApiFootball by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_LIVESCORE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }
    const val BASE_URL_LIVESCORE = "https://livescore-api.com/api-client/"

    val apiService: ApiFootballService by lazy {
        retrofitApiFootball.create(ApiFootballService::class.java)
    }}
