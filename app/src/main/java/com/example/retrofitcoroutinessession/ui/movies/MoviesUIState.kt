package com.example.retrofitcoroutinessession.ui.movies

import com.example.retrofitcoroutinessession.data.Movie


data class MoviesUIState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val movies: List<Movie> = emptyList()
)
