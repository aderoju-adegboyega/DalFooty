package com.example.csci4176groupproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyTeamAdapter : BaseAdapter {
    var dataList: List<MyTeamItem>

    constructor(dataList: List<MyTeamItem>) : super() {
        this.dataList = dataList
    }


    override fun getCount() = this.dataList.size

    override fun getItem(position: Int) = this.dataList[position]

    override fun getItemId(position: Int) = 0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var item = this.dataList[position]
        var itemView = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.adapter_goals_layout, parent, false)
        var tvName = itemView.findViewById<TextView>(R.id.textView1)
        tvName.text = "${item.index}"

        var textView2 = itemView.findViewById<TextView>(R.id.textView2)
        textView2.text = item.plaqes
        var textView3 = itemView.findViewById<TextView>(R.id.textView3)
        textView3.text = item.team
        var textView4 = itemView.findViewById<TextView>(R.id.textView4)
        textView4.text = "${item.goals}"

        return itemView
    }
}