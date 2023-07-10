package com.example.moivesbox.viewmodl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moivesbox.Modlse.Home.genres_list.genres_lisItem
import com.example.moivesbox.Modlse.Home.genres_list
import com.example.moivesbox.repository.Genres_Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class Genres_ViewModle @Inject constructor(private val Genres_Repository:Genres_Repository):ViewModel() {

     val get_genres=MutableLiveData<genres_list.genres_lisItem>()

    fun get_genres_list()=viewModelScope.launch {
         val responses=Genres_Repository.get_genres_list()
        if (responses.isSuccessful){
            get_genres.postValue(responses.body())
        }
    }
}