package com.demo.countryapp.di

import com.demo.countryapp.data.network.ApiService
import com.demo.countryapp.data.repository.UserRepoImpl
import com.demo.countryapp.domain.repository.UserRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    val BASE_URL : String = "https://5e510330f2c0d300147c034c.mockapi.io"
    @Provides
    fun provideApiService() : ApiService{
       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    @Provides
    fun provideUserRepo(apiService: ApiService) : UserRepo{
        return UserRepoImpl(apiService)
    }
}