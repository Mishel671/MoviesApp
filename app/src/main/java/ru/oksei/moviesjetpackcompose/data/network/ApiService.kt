package ru.oksei.moviesjetpackcompose.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.oksei.moviesjetpackcompose.data.models.MoviesDto

interface ApiService {

    @GET("/shows")
    suspend fun getAllMovies(): Response<List<MoviesDto>>
}