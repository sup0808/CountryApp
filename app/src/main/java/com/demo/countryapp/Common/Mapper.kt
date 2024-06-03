package com.demo.countryapp.Common

import com.demo.countryapp.data.model.UserDTO
import com.demo.countryapp.domain.model.User

fun UserDTO.toDomain(): User {
    return User(
        avatar = avatar?: "",
        device_Token = device_Token?: "",
        email = email?: "",
        id = id ?:0,
        name = name ?: "",
        userId = userId ?: "",
        userToken = userToken ?: ""
    )
}