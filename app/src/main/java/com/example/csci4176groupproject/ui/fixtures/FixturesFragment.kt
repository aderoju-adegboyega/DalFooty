package com.example.csci4176groupproject.ui.fixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csci4176groupproject.R
import com.example.csci4176groupproject.ui.API.ApiResponse
import com.example.csci4176groupproject.ui.API.RetrofitInstance
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FixturesFragment : Fragment() {
    private lateinit var fixturesViewModel: FixturesViewModel
    private lateinit var fixturesAdapter: FixturesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fixturesViewModel = ViewModelProvider(this).get(FixturesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_fixtures, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_fixtures)

        fixturesAdapter = FixturesAdapter(emptyList())
        recyclerView.adapter = fixturesAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        fixturesViewModel.fixtures.observe(viewLifecycleOwner, Observer { fixtures ->
            fixturesAdapter.fixtures = fixtures
            fixturesAdapter.notifyDataSetChanged()
        })
        fetchFixtures()
        return root
    }

    private fun fetchFixtures() {
        val apiService = RetrofitInstance.apiService
        apiService.getEvents("2", "fxOANtw4UPrhVmki", "rVTQtyInUZDFdqysXn3LRzPLoh2jDnB5", "").enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { apiResponse ->
                        if (apiResponse.data.fixtures != null) {
                            fixturesViewModel.setFixtures(apiResponse.data.fixtures)
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

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                // Handle the failure
                showErrorMessage("Error: ${t.localizedMessage}")
            }
        })
    }
    private fun showErrorMessage(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
    }
}
