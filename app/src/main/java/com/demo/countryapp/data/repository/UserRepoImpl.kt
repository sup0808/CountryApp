package com.demo.countryapp.data.repository

import com.demo.countryapp.Common.toDomain
import com.demo.countryapp.data.model.CountryDTO
import com.demo.countryapp.data.network.ApiService
import com.demo.countryapp.domain.model.User

class UserRepoImpl(private  val apiService: ApiService): UserRepo {
    override suspend fun getUserList(): List<User> {
        val data = apiService.getUserList();
        return  data.map {
            it.toDomain()
        }
    }

    override suspend fun getCountryList(): CountryDTO {
        return apiService.getCountryList()
    }

    override suspend fun getMoreUserList(): List<User> {
        val data = apiService.getUserList();
        return  data.map {
            it.toDomain()
        }
    }




}