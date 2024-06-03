package com.demo.countryapp.data.network

import com.demo.countryapp.data.model.BaseUserModel
import com.demo.countryapp.data.model.CountryDTO
import com.demo.countryapp.data.model.UserDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

  /*  @GET("/users")
   suspend fun getUserList(): Response<BaseUserModel>*/

    @GET("/users")
    suspend fun getUserList():List<UserDTO>

    @GET("/more-users")
    suspend fun getMoreUserList():List<UserDTO>

    @GET("b/6659b4f5e41b4d34e4fc6332")
    suspend fun getCountryList(): CountryDTO
}
