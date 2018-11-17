package com.mashup.mashup_android_6th.network

import com.mashup.mashup_android_6th.models.SampleResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SampleAPI {
  @GET("search/users")
  fun search(@Query("q") query: String,
             @Query("page") page: Int,
             @Query("per_page") perPage: Int): Observable<SampleResult>
  @GET("/")
  fun search2(): Observable<SampleResult>

  /**
   * Companion object to create the GithubApiService
   */
  companion object Factory {
    fun create(): SampleAPI {
      val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.github.com/")
        .build()

      return retrofit.create(SampleAPI::class.java);
    }
  }
}
