package com.demo.countryapp.data.network

import com.demo.countryapp.data.model.UserDTO
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun getUserList(): List<UserDTO>
}