//class name: AssistsItem
//By Chengwen Yang
package com.example.csci4176groupproject.ui.statistics

import com.google.gson.annotations.SerializedName

//represents an item in a list of soccer players with the most assists in a league
data class AssistsItem(
    var index: Int,
    var name: String = "",
    @SerializedName("team")
    var team: Team = Team(),
    var goals: Int = 0,
    var assists: Int = 0
)




data class Team(var id:Int=0,var name:String="")