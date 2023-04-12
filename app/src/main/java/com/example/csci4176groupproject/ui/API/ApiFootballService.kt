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

    @GET("competitions/standings.json")
    fun getLeagues(
        @Query("competition_id") competition_id: String,
        @Query("key") key: String,
        @Query("secret") secret: String
    ): Call<ApiResponseLeague>
    @GET("competitions/goalscorers.json")
    fun getGoals(
        @Query("competition_id") competition_id: String,
        @Query("key") key: String,
        @Query("secret") secret: String
    ): Call<ApiResponseGolas>

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
