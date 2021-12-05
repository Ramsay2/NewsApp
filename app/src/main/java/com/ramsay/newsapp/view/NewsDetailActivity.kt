package com.ramsay.newsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ramsay.newsapp.R
import com.ramsay.newsapp.databinding.ActivityNewsDetailBinding
import com.ramsay.newsapp.models.local.News

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val news = intent.getSerializableExtra("news")
        binding.news = news as News?
        if (news != null) {
            Glide.with(binding.imageView).load(news.urlToImage).into(binding.imageView)
        }
    }
}