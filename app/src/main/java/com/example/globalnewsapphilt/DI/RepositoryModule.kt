package com.example.globalnewsapphilt.DI

import com.example.globalnewsapphilt.Rest.NewsRepository
import com.example.globalnewsapphilt.Rest.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun NewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}