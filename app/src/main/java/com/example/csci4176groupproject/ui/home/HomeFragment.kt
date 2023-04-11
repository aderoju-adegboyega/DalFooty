package com.example.csci4176groupproject.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.csci4176groupproject.R
import com.example.csci4176groupproject.databinding.FragmentHomeBinding
import com.example.csci4176groupproject.ui.API.NewsApiResponse
import com.example.csci4176groupproject.ui.API.NewsApiRetrofitInstance
import com.example.csci4176groupproject.ui.news.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.coroutines.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        fetchHomeNewsData()

        Handler().postDelayed({
            updateHomeNews(root)
        }, 2000)

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val buttonClick = binding.button
        buttonClick.setOnClickListener{
            val intent = Intent(activity, ResultsActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    private fun updateHomeNews(root: View) {
        val article = homeViewModel.homeNews.value?.get(0)

        val latestNewsTitleView1: TextView = root.findViewById(R.id.latestNewsTitle1)

        latestNewsTitleView1.text = article?.title

        val latestNewsView1: LinearLayout = root.findViewById(R.id.latestNews1)

        latestNewsView1.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(article?.url))
            startActivity(browserIntent)
        }
    }

    private fun fetchHomeNewsData() {
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
                        homeViewModel.setHomeNews(articles)
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