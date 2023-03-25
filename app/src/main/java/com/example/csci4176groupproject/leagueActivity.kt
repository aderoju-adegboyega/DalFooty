package com.example.csci4176groupproject

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.csci4176groupproject.databinding.ActivityLeagueBinding

class leagueActivity : AppCompatActivity() {
    lateinit var adapter: LeagueAdapter
    val dataList = mutableListOf<League>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind = ActivityLeagueBinding.inflate(layoutInflater, null, false)
        setContentView(bind.root)
        setTitle("League Table")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fillData()

        adapter = LeagueAdapter(dataList)
        bind.lv.adapter = adapter
    }

    private fun fillData() {
        arrayOf("NAME1", "NAME2", "NAME3").forEach { s ->
            dataList.add(League(name = s))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}