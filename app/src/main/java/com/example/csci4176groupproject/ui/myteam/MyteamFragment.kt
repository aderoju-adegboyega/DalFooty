package com.example.csci4176groupproject.ui.myteam

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.csci4176groupproject.R
import com.example.csci4176groupproject.databinding.FragmentMyteamBinding


class MyteamFragment : Fragment() {

    private var _binding: FragmentMyteamBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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
        initTeamData();
        return root
    }
    private var team: String = "Aston Villa"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.spinner.onItemSelectedListener  = object :OnItemSelectedListener{


            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                activity?.let {
                    team = it.resources.getStringArray(R.array.teams)[p2]
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        binding.btnSelect.setOnClickListener {
            activity?.let {
                var sp = it.getSharedPreferences("team", Context.MODE_PRIVATE)
                sp.edit().putString("team",team).commit()
                initTeamData()
            }
        }
    }

    private fun initTeamData() {
        activity?.let {
            var sp = it.getSharedPreferences("team", Context.MODE_PRIVATE)
            var team = sp.getString("team",team)
            if (!TextUtils.isEmpty(team)){
                binding.noTeam.visibility = View.GONE
                binding.hasTeam.visibility = View.VISIBLE
            }else{
                binding.noTeam.visibility = View.VISIBLE
                binding.hasTeam.visibility = View.GONE
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.add(0,1001,1,"Change Team")
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==1001){
            binding.noTeam.visibility = View.VISIBLE
            binding.hasTeam.visibility = View.GONE
        }
        return true

    }



}