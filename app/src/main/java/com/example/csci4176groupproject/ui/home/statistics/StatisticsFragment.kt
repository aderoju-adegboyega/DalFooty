package com.example.csci4176groupproject.ui.home.statistics

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.csci4176groupproject.AssistsActivity
import com.example.csci4176groupproject.GoalsActivity
import com.example.csci4176groupproject.databinding.FragmentStatisticsBinding
import com.example.csci4176groupproject.leagueActivity

class StatisticsFragment : Fragment() {

    private var _binding: FragmentStatisticsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val statisticsViewModel =
            ViewModelProvider(this).get(StatisticsViewModel::class.java)

        _binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        _binding?.textView5?.setOnClickListener {
            startActivity(Intent(it.context, leagueActivity::class.java))
        }
        _binding?.textView6?.setOnClickListener {
            startActivity(Intent(it.context, GoalsActivity::class.java))
        }
        _binding?.textView7?.setOnClickListener {
            startActivity(Intent(it.context, AssistsActivity::class.java))
        }
        _binding?.button?.setOnClickListener {
            AlertDialog.Builder(it.context)
                .setTitle("Detail")
                .setPositiveButton("Back",null)
                .setItems(arrayOf("team 1 details","team 1 details"), object : OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(it.context, "click", Toast.LENGTH_SHORT).show()
                }
            }).show()
        }
        _binding?.button2?.setOnClickListener {
            AlertDialog.Builder(it.context)
                .setTitle("Detail")
                .setPositiveButton("Back",null)
                .setItems(arrayOf("team 2 details","team 2 details"), object : OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(it.context, "click", Toast.LENGTH_SHORT).show()
                    }
                }).show()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}