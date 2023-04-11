package com.example.csci4176groupproject.ui.API

data class ResultsApiResponse(
    val success: Boolean,
    val data: Data
) {
    data class Data(
        val match: List<Match>
    ) {
        data class Match(
            val home_name: String,
            val away_name: String,
            val score: String,
            val date: String
        )
    }
}
