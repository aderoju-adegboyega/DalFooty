//class name: LeagueAdaptor
//By Chengwen Yang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.csci4176groupproject.R
import com.example.csci4176groupproject.ui.statistics.League

class LeagueAdapter : BaseAdapter {
    var dataList: List<League>

    constructor(dataList: List<League>) : super() {
        this.dataList = dataList
    }


    override fun getCount() = this.dataList.size

    override fun getItem(position: Int) = this.dataList[position]

    override fun getItemId(position: Int) = 0L
//provide a custom view for each item in the list view.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var league = this.dataList[position]
        var itemView = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.adapter_league_layout, parent, false)
        var tvName = itemView.findViewById<TextView>(R.id.textView1)
        tvName.text = league.name

        var textView2 = itemView.findViewById<TextView>(R.id.textView2)
        textView2.text = "${league.matches}"
        var textView3 = itemView.findViewById<TextView>(R.id.textView3)
        textView3.text = "${league.won}"
        var textView4 = itemView.findViewById<TextView>(R.id.textView4)
        textView4.text = "${league.drawn}"
        var textView5 = itemView.findViewById<TextView>(R.id.textView5)
        textView5.text = "${league.lost}"
        var textView6 = itemView.findViewById<TextView>(R.id.textView6)
        textView6.text = "${league.points}"
        var textView7 = itemView.findViewById<TextView>(R.id.textView7)
        textView7.text = "${league.goal_diff}"


        return itemView
    }
}