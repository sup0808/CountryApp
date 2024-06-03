package com.demo.countryapp.domain.repository

import com.demo.countryapp.domain.model.User

interface UserRepo
{
  suspend  fun getUserList(): List<User>
}