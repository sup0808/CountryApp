package com.demo.countryapp.domain.model

data class User(
    val avatar: String?,
    val device_Token: String?,
    val email: String?,
    val id: Int,
    val name: String,
    val userId: String,
    val userToken: String
)