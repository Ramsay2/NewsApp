package com.ramsay.newsapp.models.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNews(article: List<News>)

    @Query("select * from news")
    fun getNews(): LiveData<List<News>>

}