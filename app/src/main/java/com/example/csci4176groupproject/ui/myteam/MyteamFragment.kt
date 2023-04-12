package com.example.csci4176groupproject.ui.myteam

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.csci4176groupproject.databinding.FragmentMyteamBinding
import com.example.csci4176groupproject.ui.API.ApiResponseTeamMatches
import com.example.csci4176groupproject.ui.API.ApiResponseTeams
import com.example.csci4176groupproject.ui.API.RetrofitInstance
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date


class MyteamFragment : Fragment() {

    lateinit var _binding: FragmentMyteamBinding


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
var teamid = 0
    private var team: Teams = Teams()
    private var spDataList: List<Teams> = mutableListOf()
    private var teamDataList: List<TeamMatches> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myteamViewModel =
            ViewModelProvider(this).get(MyteamViewModel::class.java)

        _binding = FragmentMyteamBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMyteam
        myteamViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        setHasOptionsMenu(true);
        initTeamData()
        fillData()
        var sp = requireContext().getSharedPreferences("team", Context.MODE_PRIVATE)
          teamid= sp.getInt("team", 0)
        if(teamid!=0){
            team.id = teamid
            fillTeamMatchesData()
        }
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                activity?.let {
                    team = binding.spinner.adapter.getItem(p2) as Teams
                    _binding.textMyteam.text = team?.name
                    fillTeamMatchesData()
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        binding.btnSelect.setOnClickListener {
            activity?.let {
                var sp = it.getSharedPreferences("team", Context.MODE_PRIVATE)
                sp.edit().putInt("team", team?.id?:0).commit()
                initTeamData()
            }
        }
    }

    private fun initTeamData() {
        activity?.let {

            if (teamid==0) {
                binding.noTeam.visibility = View.GONE
                binding.hasTeam.visibility = View.VISIBLE
            } else {

                binding.noTeam.visibility = View.VISIBLE
                binding.hasTeam.visibility = View.GONE
            }
        }

    }

    private fun fillData() {

        val apiService = RetrofitInstance.apiService
        apiService.getTeams("fxOANtw4UPrhVmki", "rVTQtyInUZDFdqysXn3LRzPLoh2jDnB5").enqueue(object :
            Callback<ApiResponseTeams> {
            override fun onResponse(
                call: Call<ApiResponseTeams>,
                response: Response<ApiResponseTeams>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { apiResponse ->
                        if (apiResponse.data.teams != null) {
                            spDataList = apiResponse.data.teams
                            binding.spinner.adapter = SpAdapter(spDataList)

                            _binding.textMyteam.text = spDataList[0].name
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

            override fun onFailure(call: Call<ApiResponseTeams>, t: Throwable) {
                // Handle the failure
                showErrorMessage("Error: ${t.localizedMessage}")
            }
        })
    }

    private fun fillTeamMatchesData() {
        val apiService = RetrofitInstance.apiService
        apiService.getTeamMatches(
            "${team?.id}", "10",
            "fxOANtw4UPrhVmki", "rVTQtyInUZDFdqysXn3LRzPLoh2jDnB5"
        ).enqueue(object :
            Callback<ApiResponseTeamMatches> {
            override fun onResponse(
                call: Call<ApiResponseTeamMatches>,
                response: Response<ApiResponseTeamMatches>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { apiResponse ->
                        if (apiResponse.data != null) {
                            teamDataList = apiResponse.data
                            if(teamDataList.size>3){
                                _binding.tvDate1.text = teamDataList[0].date
                                _binding.tvDate2.text = teamDataList[1].date
                                _binding.tvDate3.text = teamDataList[2].date

                                _binding.tvVs1.text = "VS      ${teamDataList[0].away_name}"
                                _binding.tvVs2.text = "VS      ${teamDataList[1].away_name}"
                                _binding.tvVs3.text = "VS      ${teamDataList[2].away_name}"


                                var split = teamDataList[0].score.split("-")
                                _binding.textView5.text = split[0]
                                _binding.textView6.text = split[split.size-1]

                                _binding.textView3.text=teamDataList[0].home_name
                                _binding.textView4.text=teamDataList[0].away_name
                            }



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

            override fun onFailure(call: Call<ApiResponseTeamMatches>, t: Throwable) {
                // Handle the failure
                showErrorMessage("Error: ${t.localizedMessage}")
            }
        })
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(_binding.root, message, Snackbar.LENGTH_LONG).show()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.add(0, 1001, 1, "Change Team")
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == 1001) {
            binding.noTeam.visibility = View.VISIBLE
            binding.hasTeam.visibility = View.GONE
        }
        return true

    }


}