package com.demo.countryapp.domain.usecase

import com.demo.countryapp.Common.Resource
import com.demo.countryapp.data.model.CountryDTO
import com.demo.countryapp.data.repository.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class GetCountryListUsecase @Inject constructor(val userRepo: UserRepo) {

    operator fun invoke() : Flow<Resource<CountryDTO>> = flow{
        emit(Resource.Loading())
        try{
            val countryData = userRepo.getCountryList()
            emit(Resource.Success(countryData))
        }
        catch (e : Throwable){
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}