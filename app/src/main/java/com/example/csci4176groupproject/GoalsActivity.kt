package com.example.csci4176groupproject

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.csci4176groupproject.databinding.ActivityGoalsBinding


class GoalsActivity : AppCompatActivity() {
    lateinit var adapter: MyTeamAdapter
    val dataList = mutableListOf<goalsItem>()
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

    private fun fillData() {

        dataList.add(goalsItem(1, "Granit Xhaka", "Arsenal", 35))
        dataList.add(goalsItem(2, "Scott Carson", "Manchester City", 52))
        dataList.add(goalsItem(3, "Martin Dubravka", "Newcastle United", 83))
        dataList.add(goalsItem(4, "Hugo Lloris", "Tottenham Hotspur", 66))
        dataList.add(goalsItem(5, "Ashley Young", "Aston Villa", 76))
        dataList.add(goalsItem(6, "James Milner", "Liverpool", 102))
        dataList.add(goalsItem(7, "ChristianeNord", "Brentford", 79))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}