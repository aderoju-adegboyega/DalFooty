package com.example.csci4176groupproject.ui.API

import com.example.csci4176groupproject.ui.fixtures.Fixture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiFootballService {
    @GET("fixtures/matches.json")
    fun getEvents(
        @Query("competition_id") competition_id: String,
        @Query("key") key: String,
        @Query("secret") secret: String,
        @Query("date") date: String
    ): Call<ApiResponse>
}
