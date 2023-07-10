package com.example.moivesbox.viewmodl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moivesbox.Modlse.Register.Body_Users
import com.example.moivesbox.Modlse.Register.Respons_Users
import com.example.moivesbox.repository.Register_Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class Register_Viewmodel @Inject constructor(private val Repository: Register_Repository) :
    ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val Register_User = MutableLiveData<Respons_Users>()

    fun register_user( Body : Body_Users)=viewModelScope.launch {
        val response = Repository.Register_User(Body)
        loading.postValue(true)
        if (response.isSuccessful) {
            Register_User.postValue(response.body())
        }
        loading.postValue(false)
    }
}