package com.example.globalnewsapphilt.Rest


import com.example.globalnewsapphilt.Model.CountryModel.CountryResponse
import com.example.globalnewsapphilt.Model.NewsModel.NewsResponse
import com.example.globalnewsapphilt.Rest.CountryApi.Companion.SEARCH_PATH
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




 interface CountryApi {

         @GET(SEARCH_PATH)
         suspend fun getCountry(
            @Path("") country: String?
         ): Response<CountryResponse>



       companion object{
           //    https://restcountries.com/v2/name/peru

           const val BASE_URL ="https://restcountries.com/"
           private const val SEARCH_PATH = "v2/name/"
       }

 }







