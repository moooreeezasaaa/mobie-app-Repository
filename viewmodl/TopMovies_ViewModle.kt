package com.example.moivesbox.viewmodl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moivesbox.Modlse.Home.TopMovies_moviesapi
import com.example.moivesbox.Modlse.Home.topmovies
import com.example.moivesbox.repository.TopMovies_Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopMovies_ViewModle @Inject constructor(private val Repository: TopMovies_Repository) :
    ViewModel() {

    val Top_movie_loading = MutableLiveData<Boolean>()
    val Top_movies_responses = MutableLiveData<TopMovies_moviesapi>()

    fun get_Movies() = viewModelScope.launch {
        val response = Repository.TopMovies()
        Top_movie_loading.postValue(true)
        if (response.isSuccessful) {
            Top_movies_responses.postValue(response.body())
        }
        Top_movie_loading.postValue(false)
    }
}
