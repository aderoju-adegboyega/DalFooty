package com.example.csci4176groupproject.ui.API

import com.example.csci4176groupproject.ui.statistics.AssistsItem
import com.example.csci4176groupproject.ui.statistics.League
import com.example.csci4176groupproject.ui.fixtures.Fixture
import com.example.csci4176groupproject.ui.myteam.TeamMatches
import com.example.csci4176groupproject.ui.myteam.Teams
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


data class ApiResponseTeams(
    @SerializedName("data")
    val data: TeamsData
)

data class TeamsData(
    @SerializedName("teams")
    val teams: List<Teams>
)

data class ApiResponseTeamMatches(
    @SerializedName("data")
    val data: List<TeamMatches>
)
