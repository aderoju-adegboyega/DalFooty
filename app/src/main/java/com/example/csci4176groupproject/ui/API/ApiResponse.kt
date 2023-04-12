package com.example.csci4176groupproject.ui.API

import com.example.csci4176groupproject.ui.myteam.TeamMatches
import com.example.csci4176groupproject.ui.myteam.Teams
import com.google.gson.annotations.SerializedName


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
