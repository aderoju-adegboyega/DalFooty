package com.example.csci4176groupproject.ui.news

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csci4176groupproject.R

class NewsAdapter(var articles: List<Article>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = articles[position]
        holder.titleTextView.text = currentItem.title

        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(currentItem.url))
            holder.itemView.context.startActivity(browserIntent)
        }
    }

    override fun getItemCount(): Int = articles.size

    fun updateData(newArticles: List<Article>) {
        articles = newArticles
        notifyDataSetChanged()
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tv_news_title)
    }
}
