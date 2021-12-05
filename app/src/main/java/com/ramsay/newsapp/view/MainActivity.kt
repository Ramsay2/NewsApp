package com.ramsay.newsapp.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramsay.newsapp.databinding.ActivityMainBinding
import com.ramsay.newsapp.models.local.News
import com.ramsay.newsapp.viewModels.NewsViewModels
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val newsViewModels: NewsViewModels by viewModels()
    private var newsList = mutableListOf<News>()
    private lateinit var newsAdapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        getNews()

    }

    fun setAdapter() {
        newsAdapter = NewsAdapter(this, newsList)
        binding.apply {
            recyclerview.layoutManager = LinearLayoutManager(applicationContext)
            recyclerview.adapter = newsAdapter
        }
    }

    fun getNews() {
        newsViewModels.getNewsFromApi()

        newsViewModels.getNewsFromDB().observe(this, Observer {
            val news = it
            newsList.addAll(news)
            newsList.reverse()
            newsAdapter.notifyDataSetChanged()

        })
    }

}