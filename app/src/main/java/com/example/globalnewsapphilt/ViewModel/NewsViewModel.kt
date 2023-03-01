package com.example.globalnewsapphilt.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalnewsapphilt.Model.Domain.NewsDomain
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

    var title = ""
    var author = ""
    var urlToImage = ""
    var publishedAt = ""
    var description = ""


    private val _news: MutableLiveData<UIState<List<NewsDomain>>>
        = MutableLiveData(UIState.LOADING)
    val news: LiveData<UIState<List<NewsDomain>>> get() = _news


    init{
        getNews()
    }

    private fun getNews(from: String?= null , to: String?= null) {
        if (from != null && to != null){
            viewModelScope.launch(ioDispatcher){
                newsRepository.getNews(from, to).collect{
                    _news.postValue(it)
                }
            }
        }
    }


}
