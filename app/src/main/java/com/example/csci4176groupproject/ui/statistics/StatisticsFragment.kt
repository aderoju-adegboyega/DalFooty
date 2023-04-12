// Class name: StatisticsFragment
// By Chengwen Yang
package com.example.csci4176groupproject.ui.statistics

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
import com.example.csci4176groupproject.databinding.FragmentStatisticsBinding

//allows the code to access the views defined in the fragment's layout file.
class StatisticsFragment : Fragment() {

    private var _binding: FragmentStatisticsBinding? = null

    private val binding get() = _binding!!
//overridden to inflate the fragment's layout and initialize its views
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val statisticsViewModel =
            ViewModelProvider(this).get(StatisticsViewModel::class.java)
//pop up windows
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
                .setItems(arrayOf("Manchester United Football Club",
                    "A professional football club based in Old Trafford, Greater Manchester, England"
                ,"Manchester United have won a record 20 League titles, 12 FA Cups, six League Cups, and a record 21 FA Community Shields"), object : OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(it.context, "click", Toast.LENGTH_SHORT).show()
                }
            }).show()
        }
        _binding?.button2?.setOnClickListener {
            AlertDialog.Builder(it.context)
                .setTitle("Detail")
                .setPositiveButton("Back",null)
                .setItems(arrayOf("Futbol Club Barcelona","A professional football club based in Barcelona, Catalonia, Spain", "Founded in 1899 by a group of Swiss, Catalan, German, and English footballers led by Joan Gamper, the club has become a symbol of Catalan culture and Catalanism"), object : OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(it.context, "click", Toast.LENGTH_SHORT).show()
                    }
                }).show()
        }
        return root
    }
//overridden to clean up the _binding property and prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}