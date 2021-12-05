package com.ramsay.newsapp.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ramsay.newsapp.models.response.Source


@Entity(tableName = "news")
data class News(
    @ColumnInfo(name = "author")
    val author: Any,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String,
    @ColumnInfo(name = "source")
    val source: Source,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id1")
    var id1 :Int? = null
}