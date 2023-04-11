package com.example.csci4176groupproject.ui.results

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csci4176groupproject.R

class ResultsAdapter(var results: List<Result>) : RecyclerView.Adapter<ResultsAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val currentItem = results[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = results.size

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val homeNameTextView: TextView = itemView.findViewById(R.id.result_home_name)
        private val awayNameTextView: TextView = itemView.findViewById(R.id.result_away_name)
        private val scoreTextView: TextView = itemView.findViewById(R.id.result_score)
        private val dateTextView: TextView = itemView.findViewById(R.id.result_date)
        private val homeLogoImageView: ImageView = itemView.findViewById(R.id.result_home_logo)
        private val awayLogoImageView: ImageView = itemView.findViewById(R.id.result_away_logo)

        fun bind(result: Result) {
            homeNameTextView.text = result.homeName
            awayNameTextView.text = result.awayName
            scoreTextView.text = result.score
            dateTextView.text = result.date
            homeLogoImageView.setImageResource(getTeamLogoResource(result.homeName))
            awayLogoImageView.setImageResource(getTeamLogoResource(result.awayName))
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


}


