package com.example.retrofitcoroutinessession.data

import com.example.retrofitcoroutinessession.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/{movie_id}")
    fun getMovieDetailsById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
    ): MovieDetailsResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("page") page: Int? = 1,
        @Query("api_key") apiKey: String = API_KEY,
    ): MoviesNowPlayingResponse


}