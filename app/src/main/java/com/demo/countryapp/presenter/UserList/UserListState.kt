package com.demo.countryapp.presenter.UserList

import com.demo.countryapp.domain.model.User

class UserListState (

    val isLoading : Boolean = false,
    val error : String = "",
    val data : List<User>? =null
)