package com.ramsay.newsapp.repository

import androidx.appcompat.resources.Compatibility
import com.ramsay.newsapp.models.Network
import com.ramsay.newsapp.models.NewsApiService
import com.ramsay.newsapp.models.local.NewsDAO
import javax.inject.Inject

class NewsRepository @Inject constructor(val newsDAO: NewsDAO) {

    private val apiService :NewsApiService = Network.instance().create(NewsApiService::class.java)



}