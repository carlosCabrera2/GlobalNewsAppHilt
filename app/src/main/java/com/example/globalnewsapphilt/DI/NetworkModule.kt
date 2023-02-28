package com.example.globalnewsapphilt.DI

import com.example.globalnewsapphilt.Rest.NewsApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

@Provides
fun providesGson(): Gson = Gson()

@Provides
fun providesRetrofit(
    okHttpClient: OkHttpClient,
    gson: Gson
): Retrofit =
    Retrofit.Builder()
        .baseUrl(NewsApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory)
        .client(okHttpClient)
        .build()

@Provides
fun providesOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor

)

















}