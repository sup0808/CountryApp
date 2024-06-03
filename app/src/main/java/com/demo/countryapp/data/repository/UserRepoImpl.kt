package com.demo.countryapp.data.repository

import com.demo.countryapp.Common.toDomain
import com.demo.countryapp.data.network.ApiService
import com.demo.countryapp.domain.model.User
import com.demo.countryapp.domain.repository.UserRepo

class UserRepoImpl(private  val apiService: ApiService): UserRepo {
    override fun getUserList(): List<User> {
        return  apiService.getUserList().map { it.toDomain() }
    }

}