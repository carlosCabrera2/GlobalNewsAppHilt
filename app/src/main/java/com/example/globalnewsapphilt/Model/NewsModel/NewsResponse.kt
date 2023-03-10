package com.example.globalnewsapphilt.Model.NewsModel


import com.example.globalnewsapphilt.Model.NewsModel.Article
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>?,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)