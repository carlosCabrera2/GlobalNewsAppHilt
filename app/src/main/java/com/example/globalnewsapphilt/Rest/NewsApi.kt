package com.example.globalnewsapphilt.Rest


import com.example.globalnewsapphilt.Model.NewsModel.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

        @GET(SEARCH_PATH)
        suspend fun getNews(
            @Query("country") country: String?,
            @Query("apiKey") apiKey: String = "92dde7b233274926a1bc1b2aab26a019"
        ): Response<NewsResponse>


        companion object{
            //    https://newsapi.org/v2/top-headlines?country=us&apiKey=92dde7b233274926a1bc1b2aab26a019

            const val BASE_URL= "https://newsapi.org/v2/"
            private const val SEARCH_PATH = "top-headlines"

        }
}












