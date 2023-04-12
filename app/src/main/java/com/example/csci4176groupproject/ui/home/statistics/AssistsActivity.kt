//class name: AssistsActivity
//By Chengwen Yang
package com.example.csci4176groupproject.ui.home.statistics

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.csci4176groupproject.databinding.ActivityAssistsBinding
import com.example.csci4176groupproject.ui.API.ApiResponseGolas
import com.example.csci4176groupproject.ui.API.RetrofitInstance
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//display a list of soccer players with the most assists in a league
class AssistsActivity : AppCompatActivity() {
    lateinit var adapter: AssistsAdapter
    val dataList = mutableListOf<AssistsItem>()
    lateinit var bind:ActivityAssistsBinding
    //overridden to set up the activity's layout, title, and back button on the action bar.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = ActivityAssistsBinding.inflate(layoutInflater, null, false)
        setContentView(bind.root)
        setTitle("Assists")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fillData()

        adapter = AssistsAdapter(dataList)
        bind.lv.adapter = adapter
    }
//initializes the list with some sample data.
    private fun fillData() {
//        dataList.add(AssistsItem(1, "Matthew Smith", "Arsenal", 14))
//        dataList.add(AssistsItem(2, "Stefan Ortega Moreno Germany", "Manchester City", 33))
//        dataList.add(AssistsItem(3, "Kieran John Trippier", "Newcastle United", 26))
//        dataList.add(AssistsItem(4, "Ivan Perišić", "Tottenham Hotspur", 76))
//        dataList.add(AssistsItem(5, "Jed John Steer", "Aston Villa", 89))
//        dataList.add(AssistsItem(6, "Jordan Henderson", "Liverpool", 123))
//        dataList.add(AssistsItem(7, "Christian Thers Norgaard", "Brentford", 58))

    val apiService = RetrofitInstance.apiService
    apiService.getGoals("1", "fxOANtw4UPrhVmki", "rVTQtyInUZDFdqysXn3LRzPLoh2jDnB5").enqueue(object :
        Callback<ApiResponseGolas> {
        override fun onResponse(call: Call<ApiResponseGolas>, response: Response<ApiResponseGolas>) {
            if (response.isSuccessful) {
                response.body()?.let { apiResponse ->
                    if (apiResponse.data.goalscorers != null) {
                        dataList.clear()
                        dataList.addAll(apiResponse.data.goalscorers)
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

        override fun onFailure(call: Call<ApiResponseGolas>, t: Throwable) {
            // Handle the failure
            showErrorMessage("Error: ${t.localizedMessage}")
        }
    })
    }
    //displays a Snackbar with an error message.
    private fun showErrorMessage(message: String) {
        Snackbar.make(bind.root, message, Snackbar.LENGTH_LONG).show()
    }
//overridden to handle clicks on the back button.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}