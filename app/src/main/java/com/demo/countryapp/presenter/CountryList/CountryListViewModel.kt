package com.demo.countryapp.presenter.CountryList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.countryapp.Common.Resource
import com.demo.countryapp.data.model.CountryDTO
import com.demo.countryapp.domain.model.User
import com.demo.countryapp.domain.usecase.GetAllUserUseCase
import com.demo.countryapp.domain.usecase.GetCountryListUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CountryListViewModel @Inject constructor(val getCountryListUsecase: GetCountryListUsecase,val getAllUserUseCase: GetAllUserUseCase) : ViewModel() {

    var _list = MutableStateFlow<Resource<CountryDTO>>(Resource.Loading())
    val list : MutableStateFlow<Resource<CountryDTO>>
        get()= _list

    var _userlist = MutableStateFlow<Resource<List<User>>>(Resource.Loading())
    val userlist : MutableStateFlow<Resource<List<User>>>
        get()= _userlist

    init {
        println("ViewModel called")
        getMoreUsersList()
    }

    fun getCountryList(){
        viewModelScope.launch {
           getCountryListUsecase().onEach {
               list.value = it
           }.launchIn(viewModelScope)
        }
    }

    fun getMoreUsersList(){
        viewModelScope.launch {
            getAllUserUseCase().onEach{
                userlist.value = it
            }.launchIn(viewModelScope)
        }
    }
}