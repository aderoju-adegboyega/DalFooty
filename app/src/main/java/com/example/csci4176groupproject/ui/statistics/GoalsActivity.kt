//class name: GoalsActivity
//By Chengwen Yang
package com.example.csci4176groupproject.ui.statistics

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.csci4176groupproject.databinding.ActivityGoalsBinding
import com.example.csci4176groupproject.ui.API.ApiResponseGolas
import com.example.csci4176groupproject.ui.API.ApiResponseLeague
import com.example.csci4176groupproject.ui.API.RetrofitInstance
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// activity is to display a list of soccer players with the most goals in a league.
class GoalsActivity : AppCompatActivity() {
    lateinit var adapter: MyTeamAdapter
    val dataList = mutableListOf<AssistsItem>()
    lateinit   var bind :ActivityGoalsBinding
    //overridden to set up the activity's layout, title, and back button on the action bar.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = ActivityGoalsBinding.inflate(layoutInflater, null, false)
        setContentView(bind.root)
        setTitle("Goals")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fillData()

        adapter = MyTeamAdapter(dataList)
        bind.lv.adapter = adapter
    }
// populate the dataList with api data and sets up an instance of the MyTeamAdapter class with the api data
    private fun fillData() {

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