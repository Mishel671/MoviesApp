package ru.oksei.moviesjetpackcompose.data.models


import com.google.gson.annotations.SerializedName

data class Country(
    val code: String,
    val name: String,
    val timezone: String
)