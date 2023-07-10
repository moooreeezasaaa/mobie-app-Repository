package com.example.moivesbox.repository

import androidx.datastore.preferences.protobuf.Api
import com.example.moivesbox.Api.ApiServices
import javax.inject.Inject

class Genres_Repository @Inject constructor(private val Api:ApiServices) {
    suspend fun get_genres_list()=Api.Get_Genres_List()
}