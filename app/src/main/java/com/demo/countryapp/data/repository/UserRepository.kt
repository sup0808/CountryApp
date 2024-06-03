package com.demo.countryapp.data.repository

import com.demo.countryapp.data.model.CountryDTO
import com.demo.countryapp.domain.model.User

interface UserRepo
{
  suspend  fun getUserList(): List<User>

  suspend  fun getMoreUserList(): List<User>

  suspend fun getCountryList() : CountryDTO
}