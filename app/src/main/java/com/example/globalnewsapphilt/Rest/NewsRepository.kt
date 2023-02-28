package com.example.globalnewsapphilt.Rest

import com.example.globalnewsapphilt.Model.Domain.NewsDomain
import com.example.globalnewsapphilt.Model.Domain.mapToDomainNews
import com.example.globalnewsapphilt.Utilities.FailureResponse
import com.example.globalnewsapphilt.Utilities.NullNewsResponse
import com.example.globalnewsapphilt.Utilities.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface NewsRepository {
    fun getNews(from: String, to: String): Flow<UIState<List<NewsDomain>>>
}



class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
):NewsRepository{

    override fun getNews(from: String, to: String):
            Flow<UIState<List<NewsDomain>>> = flow{

        emit(UIState.LOADING)

        try{
            val response = newsApi.getNews(from, to)
            if(response.isSuccessful){
                response.body()?.let{
                    emit(UIState.SUCCESS(it.articles.mapToDomainNews()))
                }?: throw NullNewsResponse()
            }else{
                throw FailureResponse(response.errorBody()?.string())
            }
        }catch(e: Exception)
        { emit(UIState.ERROR(e))
        }

    }
}