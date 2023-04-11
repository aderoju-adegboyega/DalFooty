package com.example.csci4176groupproject.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csci4176groupproject.R
import com.example.csci4176groupproject.ui.API.NewsApiResponse
import com.example.csci4176groupproject.ui.API.NewsApiRetrofitInstance
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_news)

        newsAdapter = NewsAdapter(emptyList())
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        newsViewModel.news.observe(viewLifecycleOwner, Observer { articles ->
            newsAdapter.articles = articles
            newsAdapter.notifyDataSetChanged()
        })

        fetchNewsData()

        return root
    }

    private fun fetchNewsData() {
        NewsApiRetrofitInstance.apiService.getNews(
            "premierleague",
            "2023-04-10",
            "2023-04-10",
            "popularity",
            "en",
            "e89d71a5de5046e1b28df4e39443363c"
        ).enqueue(object : Callback<NewsApiResponse> {
            override fun onResponse(call: Call<NewsApiResponse>, response: Response<NewsApiResponse>) {
                if (response.isSuccessful) {
                    response.body()?.articles?.let { articles ->
                        newsViewModel.setNews(articles)
                    }
                } else {
                    showErrorMessage("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                showErrorMessage("Error: ${t.localizedMessage}")
            }
        })
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
    }
}
