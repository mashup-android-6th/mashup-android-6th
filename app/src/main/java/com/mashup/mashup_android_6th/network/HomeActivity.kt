package com.mashup.mashup_android_6th.network

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mashup.mashup_android_6th.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class HomeActivity : AppCompatActivity() {
// 컨테이터 역할. 중앙제어.
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    val movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
    movieViewModel.movieData.observe(this, Observer { movies ->
      // TODO set movie data view
      Log.d("Result", movies.toString())
    })

    movieViewModel.getMoviews()

//    println("123123")
//    someLogic()
//    func()
  }

  private fun func() {
    val retrofit = Retrofit.Builder()
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create())
      .baseUrl("htttps://api.github.com")
      .build()

    val api = retrofit.create(TempAPI::class.java)
    api.getGithub()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        Log.d("Result", "$it")
        tvHello.text = it.emails_url
      }, { error ->
        error.printStackTrace()
      }, {
        Log.d("Result", "complete")
      })
  }

  fun someLogic() {
    val api = SampleAPI.create()
    api.search2()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({ result ->
        Log.d("Result", "1123 ${result}")
      }, { error ->
        error.printStackTrace()
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

