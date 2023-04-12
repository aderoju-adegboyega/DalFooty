//class name: League
//By Chengwen Yang
package com.example.csci4176groupproject.ui.home.statistics
//represents a soccer league and has several properties
data class League(
    var name: String = "",
    var matches: Int = 0,
    var won: Int = 0,
    var drawn: Int = 0,
    var lost: Double = 0.0,
    var F: Double = 0.0,
    var A: Int = 0,
    var goal_diff: Int = 0,
    var points: Int = 0,
)
