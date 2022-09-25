package ru.oksei.moviesjetpackcompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.oksei.moviesjetpackcompose.data.network.ApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun baseUrl() = "https://api.tvmaze.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): ApiService =
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
}