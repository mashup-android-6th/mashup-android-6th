package com.mashup.mashup_android_6th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mashup.mashup_android_6th.network.SampleAPI
import com.mashup.mashup_android_6th.network.SampleRepository
import com.mashup.mashup_android_6th.network.TempAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    println("123123")
    func()
  }

  fun func() {
    // retrofit
    val retrofit = Retrofit.Builder()
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 1
      .addConverterFactory(GsonConverterFactory.create()) // 2
      .baseUrl("https://api.github.com/")
      .build();

    val api = retrofit.create(TempAPI::class.java)
    api.getGithub()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({ result ->
        Log.d("Result", "123123 ${result}")
        tvHello.text = "yoyo ${result.emails_url}"
      }, {
        error -> error.printStackTrace()
      }, {
        Log.d("Result", "complete")
      })
  }

  fun someLogic() {
//    val api = SampleAPI.create()
//    api.search2()
//      .observeOn(AndroidSchedulers.mainThread())
//      .subscribeOn(Schedulers.io())
//      .subscribe({
//        result -> Log.d("Result", "1123 ${result}")
//      }, {
//        error -> error.printStackTrace()
//      });

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

