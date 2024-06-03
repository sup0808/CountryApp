package com.demo.countryapp.presenter.CountryList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.countryapp.Common.Resource
import com.demo.countryapp.data.model.CountryDTO
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
class CountryListViewModel @Inject constructor(val getCountryListUsecase: GetCountryListUsecase) : ViewModel() {

    var _list = MutableStateFlow<Resource<CountryDTO>>(Resource.Loading())
    val list : MutableStateFlow<Resource<CountryDTO>>
        get()= _list

  /*  init {
        println("ViewModel called")
        getCountryList()
    }*/

    fun getCountryList(){
        viewModelScope.launch {
           getCountryListUsecase().onEach {
               list.value = it
           }.launchIn(viewModelScope)
        }
    }
}