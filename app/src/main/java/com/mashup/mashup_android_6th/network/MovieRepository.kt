package com.mashup.mashup_android_6th.network

import com.mashup.mashup_android_6th.models.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepository {
    private val retrofit: Retrofit
    private val movieAPI: MovieAPI

    init {
        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://yts.am/api/v2/")
            .build()

        movieAPI = retrofit.create(MovieAPI::class.java)
    }

    suspend fun getMovies(limit: Int): Response {
        // TODO if cache exist, return cache
        // TODO if local exist, return exist
        // TODO else movie API
        return movieAPI.getMovies(limit)
    }
}