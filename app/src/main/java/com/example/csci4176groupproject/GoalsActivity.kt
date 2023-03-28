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
        arrayOf(1, 2, 3, 4, 5).forEach { s ->
            dataList.add(goalsItem(index = s))
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