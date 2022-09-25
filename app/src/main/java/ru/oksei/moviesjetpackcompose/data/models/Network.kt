package ru.oksei.moviesjetpackcompose.data.models


import com.google.gson.annotations.SerializedName

data class Network(
    val country: Country,
    val id: Int,
    val name: String,
    val officialSite: String
)