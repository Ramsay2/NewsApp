package com.ramsay.newsapp.repository

import androidx.lifecycle.LiveData
import com.ramsay.newsapp.models.Network
import com.ramsay.newsapp.models.NewsApiService
import com.ramsay.newsapp.models.local.News
import com.ramsay.newsapp.models.local.NewsDAO
import com.ramsay.newsapp.models.response.ResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsRepository @Inject constructor(val newsDAO: NewsDAO) {

    private val apiService: NewsApiService = Network.instance().create(NewsApiService::class.java)

    fun getNewsFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
           val response = apiService.getNews()
            saveToDatabase(response)
        }
    }

    fun saveToDatabase(responseDTO: ResponseDTO) {
        val newsList = ArrayList<News>()
        responseDTO.articles.forEach {
            val news = it.source.name?.let { it1 ->
                News(
                    it.content,
                    it.description,
                    it.publishedAt,
                    it1,
                    it.title,
                    it.url,
                    it.urlToImage
                )
            }
            if (news != null) {
                newsList.add(news)
            }
        }
        newsDAO.addNews(newsList)

    }
    fun getNews() :LiveData<List<News>>{
        return newsDAO.getNews()

    }

}