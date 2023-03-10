package com.example.globalnewsapphilt.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalnewsapphilt.Model.CountryModel.CountryResponse
import com.example.globalnewsapphilt.Model.CountryModel.CountryResponseItem
import com.example.globalnewsapphilt.Model.NewsModel.Article
import com.example.globalnewsapphilt.Model.NewsModel.NewsResponse
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

//    var selectCountry : CountryResponseItem = CountryResponseItem()

    private val _news: MutableLiveData<UIState<NewsResponse>> = MutableLiveData(UIState.LOADING)
    val news: LiveData<UIState<NewsResponse>> get() = _news

//    private val _country: MutableLiveData<UIState<CountryResponse>> = MutableLiveData(UIState.LOADING)
//    val country: LiveData<UIState<CountryResponse>> get() = _country



    init{
        getNews()
//        getCountry()
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

//    private fun getCountry() {
//            viewModelScope.launch(ioDispatcher) {
//                newsRepository.getCountry(country).collect{
//                    _country.postValue(it)
//                }
//            }
//    }


}
