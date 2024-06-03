package com.demo.countryapp.presenter.Navigation

sealed class NavigationItem(val route : String) {
    object UserListNavigationItem : NavigationItem("user_list")
    object CountryListNavigationItem : NavigationItem("country_list")
}