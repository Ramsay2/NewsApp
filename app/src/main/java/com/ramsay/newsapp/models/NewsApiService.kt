package com.ramsay.newsapp.models

import com.ramsay.newsapp.models.response.ResponseDTO
import retrofit2.http.GET

interface NewsApiService {

    @GET("/v2/top-headlines?country=in&apiKey=b1a734fe0abf495aaadfde2c630e5593")
    suspend fun getNews():ResponseDTO


}