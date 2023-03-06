package com.example.globalnewsapphilt.Rest


import com.example.globalnewsapphilt.Model.Article
import com.example.globalnewsapphilt.Model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(SEARCH_PATH)
    suspend fun getNews(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String = "92dde7b233274926a1bc1b2aab26a019"
//        @Query("q")country: String?,
//        @Query("from") from: String?,
//        @Query("to") to: String?,
//        @Query("sortBy") sortBy: String = "popularity",
//        @Query("apiKey") apiKey: String = "92dde7b233274926a1bc1b2aab26a019"
    ): Response<NewsResponse>

    companion object{
        const val BASE_URL= "https://newsapi.org/v2/"
        private const val SEARCH_PATH = "top-headlines"

     // https://newsapi.org/v2/
        // everything?q=apple
        // &from=2023-02-27
        // &to=2023-02-27
        // &sortBy=popularity
        // &apiKey=92dde7b233274926a1bc1b2aab26a019


    //    https://newsapi.org/v2/
    // top-headlines?
    // country=us
    // &apiKey=92dde7b233274926a1bc1b2aab26a019
    }
}


