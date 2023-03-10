package com.example.globalnewsapphilt.Rest

import android.content.ContentValues.TAG
import android.util.Log
import com.example.globalnewsapphilt.Model.CountryModel.CountryResponse
import com.example.globalnewsapphilt.Model.NewsModel.NewsResponse
import com.example.globalnewsapphilt.Utilities.FailureResponse
import com.example.globalnewsapphilt.Utilities.NullNewsResponse
import com.example.globalnewsapphilt.Utilities.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface NewsRepository {
    fun getNews(country: String): Flow<UIState<NewsResponse>>
//    fun getCountry(country: String): Flow<UIState<CountryResponse>>
}

private const val TAG = "NewsRepository"

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
//    private val countryApi: CountryApi
) : NewsRepository {

    override fun getNews(country: String):Flow<UIState<NewsResponse>> = flow {

        emit(UIState.LOADING)

        try {
            val response = newsApi.getNews(country)
            if (response.isSuccessful) {
                response.body()?.let {
                    println("Repository here $it")
                    emit(UIState.SUCCESS(it))

                } ?: throw NullNewsResponse()

            } else {
                throw FailureResponse(response.errorBody()?.string())

            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
            Log.e(TAG, "Respository.getNews: ${e.localizedMessage}",e)
        }
    }

//    override fun getCountry(country: String): Flow<UIState<CountryResponse>> = flow{
//
//        emit(UIState.LOADING)
//
//        try {
//            val response = countryApi.getCountry(country)
//            if (response.isSuccessful){
//                response.body()?.let {
//                    emit(UIState.SUCCESS(it))
//                }?: throw NullNewsResponse()
//            }else{
//                throw FailureResponse(response.errorBody()?.string())
//            }
//        }catch (e: Exception){
//            emit(UIState.ERROR(e))
//        }
//    }

}