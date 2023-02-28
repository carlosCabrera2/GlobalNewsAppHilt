package com.example.globalnewsapphilt.Utilities

import com.example.globalnewsapphilt.Model.Domain.NewsDomain

sealed class ViewType {
    data class NewsList(val newsList: NewsDomain) : ViewType()
    data class ArticlesList(val articleList: NewsDomain  ) : ViewType()
}