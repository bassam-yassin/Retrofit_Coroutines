package com.example.retrofitcoroutinessession.data

import com.example.retrofitcoroutinessession.util.Constants.API_KEY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(API_KEY)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(MovieApiService::class.java)
}