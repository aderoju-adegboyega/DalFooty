//class name: LeagueActivity
//By Chengwen Yang
package com.example.csci4176groupproject.ui.statistics

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.csci4176groupproject.databinding.ActivityLeagueBinding
import com.example.csci4176groupproject.ui.API.ApiResponseLeague
import com.example.csci4176groupproject.ui.API.RetrofitInstance
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//activity displays a soccer league table.
class leagueActivity : AppCompatActivity() {

    lateinit var adapter: LeagueAdapter
    lateinit var bind: ActivityLeagueBinding
    val dataList = mutableListOf<League>()
    //inflates the layout for the activity and sets the title of the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLeagueBinding.inflate(layoutInflater, null, false)
        setContentView(bind.root)
        setTitle("League Table")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fetchLeague()

        adapter = LeagueAdapter(dataList)
        bind.lv.adapter = adapter
    }
//representing the teams in the league and their statistics such as matches played, won, lost, goals scored, and points earned from api

    private fun fetchLeague() {
        val apiService = RetrofitInstance.apiService
        apiService.getLeagues("2", "fxOANtw4UPrhVmki", "rVTQtyInUZDFdqysXn3LRzPLoh2jDnB5").enqueue(object :
            Callback<ApiResponseLeague> {
            override fun onResponse(call: Call<ApiResponseLeague>, response: Response<ApiResponseLeague>) {
                if (response.isSuccessful) {
                    response.body()?.let { apiResponse ->
                        if (apiResponse.data.table != null) {
                            dataList.clear()
                            dataList.addAll(apiResponse.data.table)
                            adapter.notifyDataSetChanged()
                        } else {
                            // Handle the case when the result is null
                            showErrorMessage("Error: No fixtures found in the API response")
                        }
                    }
                } else {
                    // Handle the error
                    showErrorMessage("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<ApiResponseLeague>, t: Throwable) {
                // Handle the failure
                showErrorMessage("Error: ${t.localizedMessage}")
            }
        })
    }
//displays a Snackbar with an error message.
    private fun showErrorMessage(message: String) {
        Snackbar.make(bind.root, message, Snackbar.LENGTH_LONG).show()
    }
// handles the back button press event and finishes the activity.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}