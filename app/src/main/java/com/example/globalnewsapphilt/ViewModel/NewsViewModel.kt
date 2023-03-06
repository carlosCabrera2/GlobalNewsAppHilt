package com.example.globalnewsapphilt.ViewModel

import androidx.core.content.contentValuesOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalnewsapphilt.Model.Article
import com.example.globalnewsapphilt.Model.Domain.NewsDomain
import com.example.globalnewsapphilt.Model.NewsResponse
import com.example.globalnewsapphilt.Rest.NewsRepository
import com.example.globalnewsapphilt.Utilities.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val ioDispatcher: CoroutineDispatcher= Dispatchers.IO
): ViewModel() {




    var selectedArticle : Article = Article()


    private val _news: MutableLiveData<UIState<NewsResponse>> = MutableLiveData(UIState.LOADING)
    val news: LiveData<UIState<NewsResponse>> get() = _news

    private val  _article: MutableLiveData<UIState<NewsResponse>> = MutableLiveData(UIState.LOADING)
    val article: LiveData<UIState<NewsResponse>> get() =_article

    private val  _selected: MutableLiveData<Article> = MutableLiveData<Article>()
    val selected: LiveData<Article> get() =_selected

    init{
        getNews()
    }


    fun getNews() {
            viewModelScope.launch(ioDispatcher){
                newsRepository.getNews(country = "us").collect{
                    println("Here viewModel $it")
                    _news.postValue(it)
                }
        }
    }

    fun setArticle(art: Article){//just index
        _selected.postValue(art)
    }
}
