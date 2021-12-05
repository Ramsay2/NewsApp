package com.ramsay.newsapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ramsay.newsapp.models.local.News
import com.ramsay.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModels @Inject constructor(val repository: NewsRepository) :ViewModel() {

    fun getNewsFromApi(){
        repository.getNewsFromApi()
    }

    fun getNewsFromDB():LiveData<List<News>> {
        return repository.getNews()

    }

}