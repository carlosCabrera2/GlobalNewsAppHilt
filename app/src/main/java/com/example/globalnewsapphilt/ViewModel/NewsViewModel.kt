package com.example.globalnewsapphilt.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalnewsapphilt.Model.NewsModel.Article
import com.example.globalnewsapphilt.Model.NewsModel.NewsResponse
import com.example.globalnewsapphilt.Rest.NewsRepository
import com.example.globalnewsapphilt.Utilities.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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

    init{
        getNews()
    }

    fun getNews(country: String? = null) {

            viewModelScope.launch(ioDispatcher){
                country?.let {
                    newsRepository.getNews(it).collect{
                        println("Here viewModel $it")
                        _news.postValue(it)
                    }
                }
        }
    }
}
