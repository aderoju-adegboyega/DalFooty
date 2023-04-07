package com.example.csci4176groupproject.ui.fixtures

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csci4176groupproject.R

class FixturesAdapter(var fixtures: List<Fixture>) :
    RecyclerView.Adapter<FixturesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fixture_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fixture = fixtures[position]
        holder.homeTeam.text = fixture.home_name
        holder.awayTeam.text = fixture.away_name
        holder.date.text = fixture.date
    }

    override fun getItemCount(): Int {
        return fixtures.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val homeTeam: TextView = view.findViewById(R.id.tv_home_team)
        val awayTeam: TextView = view.findViewById(R.id.tv_away_team)
        val date: TextView = view.findViewById(R.id.tv_date)
    }
}
