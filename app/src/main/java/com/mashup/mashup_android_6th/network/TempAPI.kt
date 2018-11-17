package com.mashup.mashup_android_6th.network

import com.mashup.mashup_android_6th.models.Github
import io.reactivex.Observable
import retrofit2.http.GET

interface TempAPI {

  @GET("/")
  fun getGithub(): Observable<Github>
}