package com.example.moivesbox.repository

import com.example.moivesbox.Api.ApiServices
import com.example.moivesbox.Modlse.Register.Body_Users
import javax.inject.Inject

class Register_Repository @Inject constructor(private val Api:ApiServices) {

    suspend fun Register_User(bodyUsers: Body_Users)=Api.Login_Users(bodyUsers)
}