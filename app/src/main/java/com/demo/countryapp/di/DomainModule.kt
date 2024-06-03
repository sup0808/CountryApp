package com.demo.countryapp.di

import com.demo.countryapp.data.repository.UserRepo
import com.demo.countryapp.domain.usecase.GetAllUserUseCase
import com.demo.countryapp.domain.usecase.GetCountryListUsecase
import com.demo.countryapp.domain.usecase.GetUserListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Provides
    fun provideGetUserListUseCase(userRepo: UserRepo) : GetUserListUseCase{
        return GetUserListUseCase(userRepo)
    }

    @Provides
    fun provideGetCountryListUseCase(userRepo: UserRepo) : GetCountryListUsecase{
        return GetCountryListUsecase(userRepo)
    }

    @Provides
    fun provideGetAllUserListUseCase(userRepo: UserRepo) : GetAllUserUseCase{
        return GetAllUserUseCase(userRepo)
    }
}