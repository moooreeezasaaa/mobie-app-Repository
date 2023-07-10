package com.example.moivesbox.repository

import com.example.moivesbox.Api.ApiServices
import com.example.moivesbox.Api.Apiservicestopmovies
import javax.inject.Inject
import javax.inject.Named
class TopMovies_Repository  @Inject constructor(private val Api:ApiServices) {
    suspend fun TopMovies()=Api.Get_Movies_List()
}