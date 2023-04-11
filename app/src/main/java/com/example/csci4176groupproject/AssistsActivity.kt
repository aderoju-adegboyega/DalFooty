package com.example.csci4176groupproject

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.csci4176groupproject.databinding.ActivityAssistsBinding
import com.example.csci4176groupproject.databinding.ActivityGoalsBinding


class AssistsActivity : AppCompatActivity() {
    lateinit var adapter: AssistsAdapter
    val dataList = mutableListOf<AssistsItem>()
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

    private fun fillData() {
        dataList.add(AssistsItem(1, "Matthew Smith", "Arsenal", 14))
        dataList.add(AssistsItem(2, "Stefan Ortega Moreno Germany", "Manchester City", 33))
        dataList.add(AssistsItem(3, "Kieran John Trippier", "Newcastle United", 26))
        dataList.add(AssistsItem(4, "Ivan Perišić", "Tottenham Hotspur", 76))
        dataList.add(AssistsItem(5, "Jed John Steer", "Aston Villa", 89))
        dataList.add(AssistsItem(6, "Jordan Henderson", "Liverpool", 123))
        dataList.add(AssistsItem(7, "Christian Thers Norgaard", "Brentford", 58))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}