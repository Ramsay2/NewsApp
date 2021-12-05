package com.ramsay.newsapp.di

import android.content.Context
import androidx.room.Room
import com.ramsay.newsapp.models.NewsApiService
import com.ramsay.newsapp.models.local.NewsDAO
import com.ramsay.newsapp.models.local.NewsRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Singleton
    @Provides
    fun provideApi():NewsApiService{
        val builder = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(NewsApiService::class.java)

    }

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context) :NewsRoomDataBase{
        val builder = Room.databaseBuilder(
            context,NewsRoomDataBase::class.java
        ,"news_dataBase"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideDAO(db:NewsRoomDataBase):NewsDAO{

        return db.getNewsDao()
    }


}