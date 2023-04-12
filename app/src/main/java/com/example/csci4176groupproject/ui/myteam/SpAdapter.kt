package com.example.csci4176groupproject.ui.myteam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.csci4176groupproject.R

class SpAdapter : BaseAdapter {
    lateinit var dataList: List<Teams>

    constructor(dataList: List<Teams>) : super() {
        this.dataList = dataList
    }

    override fun getCount() = dataList.size

    override fun getItem(position: Int) = dataList[position]

    override fun getItemId(position: Int) = 0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView =
            LayoutInflater.from(parent?.context)
                .inflate(R.layout.adapter_team_layout, parent, false)
        var tvName = itemView.findViewById<TextView>(R.id.sp_item)
        tvName.text = dataList[position].name
        return itemView
    }
}