package com.demo.countryapp.di

import com.demo.countryapp.domain.repository.UserRepo
import com.demo.countryapp.domain.usecase.GetUserListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Provides
    fun provideGetUserListUseCase(userRepo: UserRepo) : GetUserListUseCase{
        return GetUserListUseCase(userRepo)
    }
}