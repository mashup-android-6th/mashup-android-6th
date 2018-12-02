package com.mashup.mashup_android_6th.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mashup.mashup_android_6th.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel: ViewModel() {

    val movieData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMoviews() = GlobalScope.launch(Dispatchers.Main) {
        val response = withContext(Dispatchers.IO) { MovieRepository.getMovies(5) }
        movieData.postValue(response.data.movies)
    }
}