package com.ramsay.newsapp.models.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [News::class], version = 1)
abstract class NewsRoomDataBase:RoomDatabase() {

    abstract fun getNewsDao() :NewsDAO


}