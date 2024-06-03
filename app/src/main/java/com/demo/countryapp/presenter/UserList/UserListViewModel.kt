package com.demo.countryapp.presenter.UserList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.countryapp.Common.Resource
import com.demo.countryapp.domain.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private  val getUserListUseCase: GetUserListUseCase) : ViewModel() {

        private val _list = mutableStateOf(UserListState())
        val list : State<UserListState> = _list

    init{
        getUserList()
    }
    fun getUserList(){
        viewModelScope.launch {
            getUserListUseCase().onEach {
                when (it) {
                    is Resource.Loading -> {
                        _list.value = UserListState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _list.value = UserListState(data = it.data)
                    }

                    is Resource.Error -> {
                        _list.value = UserListState(error = it.message.toString())
                    }
                }
            }.launchIn(viewModelScope)
        }
    }


}