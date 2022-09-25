package ru.oksei.moviesjetpackcompose.data.models


import com.google.gson.annotations.SerializedName

data class Schedule(
    val days: List<String>,
    val time: String
)