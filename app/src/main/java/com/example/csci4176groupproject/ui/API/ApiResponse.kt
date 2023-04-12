package com.example.csci4176groupproject.ui.API

import com.example.csci4176groupproject.ui.home.statistics.AssistsItem
import com.example.csci4176groupproject.ui.home.statistics.League
import com.example.csci4176groupproject.ui.fixtures.Fixture
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("data")
    val data: FixtureData
)

data class FixtureData(
    @SerializedName("fixtures")
    val fixtures: List<Fixture>
)


data class ApiResponseLeague(
    @SerializedName("data")
    val data: LeagueData
)

data class LeagueData(
    @SerializedName("table")
    val table: List<League>
)

data class ApiResponseGolas(
    @SerializedName("data")
    val data: GolasData
)

data class GolasData(
    @SerializedName("goalscorers")
    val goalscorers: List<AssistsItem>
)