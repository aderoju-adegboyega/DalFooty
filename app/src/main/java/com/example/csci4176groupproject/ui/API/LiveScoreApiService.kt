package com.example.csci4176groupproject.ui.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LiveScoreApiService {
    @GET("api-client/scores/history.json")
    fun getResults(
        @Query("key") key: String,
        @Query("secret") secret: String,
        @Query("competition_id") competitionId: String,
        @Query("from") from: String,
        @Query("to") to: String
    ): Call<ResultsApiResponse>
}
