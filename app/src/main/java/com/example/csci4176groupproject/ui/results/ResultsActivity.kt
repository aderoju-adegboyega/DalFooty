package com.example.csci4176groupproject.ui.results

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csci4176groupproject.R
import com.example.csci4176groupproject.ui.API.LiveScoreRetrofitInstance
import com.example.csci4176groupproject.ui.API.ResultsApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsActivity : AppCompatActivity() {

    private lateinit var resultsAdapter: ResultsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_results)
        resultsAdapter = ResultsAdapter(emptyList())
        recyclerView.adapter = resultsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchResultsData()
    }

    private fun fetchResultsData() {
        LiveScoreRetrofitInstance.apiService.getResults(
            "fxOANtw4UPrhVmki",
            "rVTQtyInUZDFdqysXn3LRzPLoh2jDnB5",
            "2"
        ).enqueue(object : Callback<ResultsApiResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ResultsApiResponse>, response: Response<ResultsApiResponse>) {
                if (response.isSuccessful) {
                    response.body()?.data?.match?.let { matches ->
                        val results = matches.map { match ->
                            Result(
                                homeName = match.home_name,
                                awayName = match.away_name,
                                score = match.score,
                                date = match.date
                            )
                        }
                        resultsAdapter.results = results
                        resultsAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResultsApiResponse>, t: Throwable) {
                // Handle error
            }
        })
    }
}
