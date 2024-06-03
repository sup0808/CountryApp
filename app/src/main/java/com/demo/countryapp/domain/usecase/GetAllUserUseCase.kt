package com.demo.countryapp.domain.usecase

import com.demo.countryapp.Common.Resource
import com.demo.countryapp.data.repository.UserRepo
import com.demo.countryapp.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetAllUserUseCase(private val userRepo: UserRepo) {

    operator fun invoke() : Flow<Resource<List<User>>> = flow<Resource<List<User>>> {
        emit(Resource.Loading())


        try{
            userRepo.getUserList()
                .zip(userRepo.getMoreUserList()) { usersFromApi, moreUsersFromApi ->
                    val allUsersFromApi = mutableListOf<User>()

                    allUsersFromApi.addAll(listOf(usersFromApi))
                    println("Users :: ${allUsersFromApi.size}")
                    allUsersFromApi.addAll(listOf(moreUsersFromApi) )
                    println("More Users :: ${allUsersFromApi.size}")
                    emit(Resource.Success(allUsersFromApi))
                    return@zip allUsersFromApi
                }
        }
        catch (e : Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}