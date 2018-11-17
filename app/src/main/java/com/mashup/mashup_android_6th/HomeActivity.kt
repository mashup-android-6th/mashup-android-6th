package com.mashup.mashup_android_6th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mashup.mashup_android_6th.network.SampleAPI
import com.mashup.mashup_android_6th.network.SampleRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    println("123123")
    someLogic()
  }

  fun someLogic() {
    val api = SampleAPI.create()
    api.search2()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({
        result -> Log.d("Result", "1123 ${result}")
      }, {
        error -> error.printStackTrace()
      });

//    SampleRepository.search()
//      .observeOn(AndroidSchedulers.mainThread())
//      .subscribeOn(Schedulers.io())
//      .subscribe ({
//          result ->
//        Log.d("Result", "There are ${result.items.size} Java developers in Lagos")
//      }, { error ->
//        error.printStackTrace()
//      })
  }
}

