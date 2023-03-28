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
        var bind =ActivityAssistsBinding.inflate(layoutInflater, null, false)
        setContentView(bind.root)
        setTitle("Assists")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fillData()

        adapter = AssistsAdapter(dataList)
        bind.lv.adapter = adapter
    }

    private fun fillData() {
        arrayOf(1, 2, 3, 4, 5).forEach { s ->
            dataList.add(AssistsItem(index = s))
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