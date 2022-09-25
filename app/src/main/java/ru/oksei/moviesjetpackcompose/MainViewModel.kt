package ru.oksei.moviesjetpackcompose

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.oksei.moviesjetpackcompose.data.ApiRepository
import ru.oksei.moviesjetpackcompose.data.models.MoviesDto
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {
    private val _moviesList = MutableLiveData<List<MoviesDto>>()
    val moviesList: LiveData<List<MoviesDto>>
        get() = _moviesList

    fun getMoviesList() {
        viewModelScope.launch {
            repository.getAllMovies().let {
                if (it.isSuccessful) {
                    _moviesList.postValue(it.body())
                } else {
                    Log.d("MainLog", "Error: ${it.errorBody()}")
                }
            }
        }
    }
}