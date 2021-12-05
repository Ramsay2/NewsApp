package com.ramsay.newsapp.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramsay.newsapp.R
import com.ramsay.newsapp.databinding.ItemViewBinding
import com.ramsay.newsapp.models.local.News

class NewsAdapter(private val context: Context, private val newsList: MutableList<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val layoutBinding: ItemViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_view, parent, false)
        return NewsViewHolder(layoutBinding)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(context, NewsDetailActivity::class.java)
            intent.putExtra("news", news)
            holder.itemView.context.startActivity(intent)
        }
        holder.getData(news)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun getData(news: News) {
            binding.news = news
            Glide.with(binding.ivNewsImage).load(news.urlToImage).into(binding.ivNewsImage)

        }


    }
}
