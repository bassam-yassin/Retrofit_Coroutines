package com.example.retrofitcoroutinessession.ui.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcoroutinessession.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    private val service = RetrofitInstance.apiService

    private val _state = MutableStateFlow(MoviesUIState())
    val state = _state.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, isError = false) }
            try {
                val movies = service.getNowPlayingMovie()
                _state.update { it.copy(movies = movies.results) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false) }
                Log.d("getMovies: ", "${e.message}")
            }
        }
    }
}