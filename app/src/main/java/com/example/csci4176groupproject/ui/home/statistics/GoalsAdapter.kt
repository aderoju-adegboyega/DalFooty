//class name: GoalsAdapter
//By Chengwen Yang
package com.example.csci4176groupproject.ui.home.statistics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.csci4176groupproject.R

// handle the data and display for a list of soccer players with the most goals in a league.
class MyTeamAdapter : BaseAdapter {
    var dataList: List<AssistsItem>

    constructor(dataList: List<AssistsItem>) : super() {
        this.dataList = dataList
    }


    override fun getCount() = this.dataList.size

    override fun getItem(position: Int) = this.dataList[position]

    override fun getItemId(position: Int) = 0L
//handles the display of the data in each row of the list view
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var item = this.dataList[position]
        var itemView = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.adapter_goals_layout, parent, false)
        var tvName = itemView.findViewById<TextView>(R.id.textView1)
        tvName.text = "${position+1}"

        var textView2 = itemView.findViewById<TextView>(R.id.textView2)
        textView2.text = item.name
        var textView3 = itemView.findViewById<TextView>(R.id.textView3)
        textView3.text = item.team?.name
        var textView4 = itemView.findViewById<TextView>(R.id.textView4)
        textView4.text = "${item.goals}"

        return itemView
    }
}