package com.example.csci4176groupproject.ui.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiFootballService {

    @GET("teams/list.json")
    fun getTeams(
        @Query("key") key: String,
        @Query("secret") secret: String
    ): Call<ApiResponseTeams>
    @GET("teams/matches.json")
    fun getTeamMatches(
        @Query("team_id") team_id: String,
        @Query("number") number: String,
        @Query("key") key: String,
        @Query("secret") secret: String
    ): Call<ApiResponseTeamMatches>

}
