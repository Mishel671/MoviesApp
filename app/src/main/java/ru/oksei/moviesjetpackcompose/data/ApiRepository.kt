package ru.oksei.moviesjetpackcompose.data

import ru.oksei.moviesjetpackcompose.data.network.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllMovies() = apiService.getAllMovies()
}