package com.demo.countryapp.domain.repository

import com.demo.countryapp.domain.model.User

interface UserRepo
{
    fun getUserList(): List<User>
}