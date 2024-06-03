package com.demo.countryapp.data.repository

import com.demo.countryapp.Common.toDomain
import com.demo.countryapp.data.network.ApiService
import com.demo.countryapp.domain.model.User
import com.demo.countryapp.domain.repository.UserRepo

class UserRepoImpl(private  val apiService: ApiService): UserRepo {
    override suspend fun getUserList(): List<User> {
        val data = apiService.getUserList();
        return  data.map {
            println("Loading Data ")
            println("cmcm"+it.userId)
            it.toDomain()
        }
    }

    /*
    * override suspend fun getUserList(): List<User> {
        val data = apiService.getUserList();
        return  data.body()!!.users.map {
            println("Loading Data ")
            println("cmcm"+it.userId)
            it.toDomain()
        }
    }*/



}