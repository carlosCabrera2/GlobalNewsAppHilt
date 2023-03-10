package com.example.globalnewsapphilt.Model.Domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.globalnewsapphilt.Model.NewsModel.Article
import com.example.globalnewsapphilt.Model.NewsModel.Source

@Entity(tableName = "news")
data class NewsDomain (
    @PrimaryKey
        val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val urlToImage: String,
    val saveArticle: Boolean
        )


fun List<Article>?.mapToDomainNews(): List<NewsDomain> =
    this?.map {
        NewsDomain(
            author = it.author ?: "author not available",
            content = it.content ?: "content not available",
            description = it.description ?: "description not available",
            publishedAt = it.publishedAt ?: "publishing date not available",
            source = it.source  ?: Source("no source", "no source"),
            title = it.title ?: "title not available",
            urlToImage = it.urlToImage ?: "image not available",
            saveArticle = false
        )
    } ?: emptyList()
