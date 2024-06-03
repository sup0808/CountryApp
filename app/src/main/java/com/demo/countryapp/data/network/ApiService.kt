package com.demo.countryapp.data.network

import com.demo.countryapp.data.model.BaseUserModel
import com.demo.countryapp.data.model.UserDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

  /*  @GET("/users")
   suspend fun getUserList(): Response<BaseUserModel>*/

    @GET("/users")
    suspend fun getUserList():List<UserDTO>
}
