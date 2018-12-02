package com.mashup.mashup_android_6th.network

import com.mashup.mashup_android_6th.models.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI{

    @GET("/list_movies.json")
    suspend fun getMovies(@Query("limit")limit:Int) : Response
}