package com.demo.countryapp.domain.usecase

import com.demo.countryapp.Common.Resource
import com.demo.countryapp.domain.model.User
import com.demo.countryapp.domain.repository.UserRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUserListUseCase(private val userRepo: UserRepo) {

    operator fun invoke() : Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading())
        try{
            emit(Resource.Success(data = userRepo.getUserList()))
        }
        catch (e : Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}