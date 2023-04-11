package com.example.csci4176groupproject

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.csci4176groupproject.databinding.ActivityLeagueBinding
import com.google.android.material.snackbar.Snackbar

class leagueActivity : AppCompatActivity() {

    lateinit var adapter: LeagueAdapter
    lateinit var bind: ActivityLeagueBinding
    val dataList = mutableListOf<League>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLeagueBinding.inflate(layoutInflater, null, false)
        setContentView(bind.root)
        setTitle("League Table")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fillData()

        adapter = LeagueAdapter(dataList)
        bind.lv.adapter = adapter
    }

    private fun fillData() {
        dataList.add(League("Arsenal", 30, 23, 4, 3.72, 29.0, 43, 73))
        dataList.add(League("Manchester City", 29, 21, 4, 4.75, 27.0, 48, 67))
        dataList.add(League("Newcastle United", 29, 15, 11, 3.48, 21.0, 27, 56))
        dataList.add(League("Manchester United", 29, 17, 5, 7.44, 37.0, 7, 56))
        dataList.add(League("Tottenham Hotspur", 30, 16, 5, 9.55, 42.0, 13, 53))
        dataList.add(League("Aston Villa", 30, 14, 5, 11.41, 40.0, 1, 47))
        dataList.add(League("Brighton and Hove Albion", 28, 13, 7, 8.52, 36.0, 16, 46))
        dataList.add(League("Liverpool", 29, 12, 8, 9.50, 35.0, 15, 44))
        dataList.add(League("Brentford", 30, 10, 13, 7.47, 40.0, 7, 43))
        dataList.add(League("Fulham", 29, 11, 6, 12.39, 40.0, -1, 39))
        dataList.add(League("Chelsea", 30, 10, 9, 11.29, 31.0, -2, 39))
        dataList.add(League("Crystal Palace", 30, 8, 9, 13.29, 40.0, -11, 33))
        dataList.add(League("Wolverhampton Wanderers", 30, 8, 7, 15.24, 42.0, -18, 31))
        dataList.add(League("West Ham United", 29, 8, 6, 15.27, 39.0, -12, 30))
        dataList.add(League("Bournemouth", 30, 8, 6, 16.28, 57.0, -29, 30))
        dataList.add(League("Leeds United", 30, 7, 8, 15.39, 54.0, -15, 29))
        dataList.add(League("Everton", 30, 6, 9, 15.23, 43.0, -20, 27))
        dataList.add(League("Nottingham Forest", 30, 6, 9, 15.24, 54.0, -30, 27))
        dataList.add(League("Leicester City", 30, 7, 4, 19.40, 52.0, -12, 25))
        dataList.add(League("Southampton", 3, 0, 6, 5.0, 19.24, 51, -27, 23))


    }

    //    private fun fetchFixtures() {
//        val apiService = RetrofitInstance.apiService
//        apiService.getEvents("2", "fxOANtw4UPrhVmki", "rVTQtyInUZDFdqysXn3LRzPLoh2jDnB5", "").enqueue(object :
//            Callback<ApiResponse> {
//            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
//                if (response.isSuccessful) {
//                    response.body()?.let { apiResponse ->
//                        if (apiResponse.data.fixtures != null) {
////                            fixturesViewModel.setFixtures()
//                            dataList.clear()
//                            apiResponse.data.fixtures.forEach {
//                                dataList.add(League(name = it.home_name))
//                            }
//                            adapter.notifyDataSetChanged()
//                        } else {
//                            // Handle the case when the result is null
//                            showErrorMessage("Error: No fixtures found in the API response")
//                        }
//                    }
//                } else {
//                    // Handle the error
//                    showErrorMessage("Error: ${response.errorBody()?.string()}")
//                }
//            }
//
//            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
//                // Handle the failure
//                showErrorMessage("Error: ${t.localizedMessage}")
//            }
//        })
//    }
    private fun showErrorMessage(message: String) {
        Snackbar.make(bind.root, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}