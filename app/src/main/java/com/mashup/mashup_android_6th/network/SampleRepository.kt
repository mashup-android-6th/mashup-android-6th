package com.mashup.mashup_android_6th.network

import com.mashup.mashup_android_6th.models.SampleResult
import io.reactivex.Observable

class SampleRepository(val apiService: SampleAPI) {
  fun search(): Observable<SampleResult> {
//    return apiService.search(query = "location:$location+language:$language")
    return apiService.search2()
  }
}