package com.example.csci4176groupproject.ui.fixtures

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        holder.homeTeamLogo.setImageResource(getTeamLogoResource(fixture.home_name))
        holder.awayTeamLogo.setImageResource(getTeamLogoResource(fixture.away_name))

    }

    override fun getItemCount(): Int {
        return fixtures.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val homeTeam: TextView = view.findViewById(R.id.tv_home_team)
        val awayTeam: TextView = view.findViewById(R.id.tv_away_team)
        val date: TextView = view.findViewById(R.id.tv_date)
        val homeTeamLogo: ImageView = view.findViewById(R.id.tv_home_team_logo)
        val awayTeamLogo: ImageView = view.findViewById(R.id.tv_away_team_logo)

    }

    private fun getTeamLogoResource(teamName: String): Int {
        return when (teamName) {
            "Arsenal" -> R.drawable._80b57fcd9996e24bc43c4df
            "Aston Villa" -> R.drawable.aston_villa_fc_crest__2016__svg
            "Brentford" -> R.drawable.brentford_fc_crest_svg
            "Brighton & Hove Albion" -> R.drawable.brighton___hove_albion_logo_svg
            "Burnley" -> R.drawable._84a9b3bb080d7616d298777
            "Chelsea" -> R.drawable._80b57fcd9996e24bc43c4e1
            "Crystal Palace" -> R.drawable.crystal_palace_fc_logo__2022__svg
            "Everton" -> R.drawable.everton_fc_logo_svg
            "Leeds United" -> R.drawable.leeds_united_f_c__logo_svg
            "Leicester City" -> R.drawable.leicester_city_crest_svg
            "Liverpool" -> R.drawable._80b57fcd9996e24bc43c4e5
            "Manchester City" -> R.drawable.manchester_city_fc_badge_svg
            "Manchester United" -> R.drawable._80b57fcd9996e24bc43c4e7
            "Newcastle United" -> R.drawable.newcastle_united_logo_svg
            "Norwich City" -> R.drawable._84a9b3bb080d7616d298777
            "Southampton" -> R.drawable.fc_southampton_svg
            "Tottenham Hotspur" -> R.drawable.tottenham_hotspur_svg
            "Watford" -> R.drawable._84a9b3bb080d7616d298777
            "West Ham United" -> R.drawable.west_ham_united_fc_logo_svg
            "Wolverhampton Wanderers" -> R.drawable.wolverhampton_wanderers_svg
            else -> R.drawable._84a9b3bb080d7616d298777 // A default logo in case the team is not found
        }
    }

}
