package com.demo.countryapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.demo.countryapp.Common.Resource
import com.demo.countryapp.presenter.CountryList.CountryListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CountryListActivity : AppCompatActivity() {
    lateinit var viewModel: CountryListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CountryListViewModel::class.java]

        loadCountryData()
    }

    fun loadCountryData() {
        lifecycleScope.launch {


            viewModel.userlist.collect {
                when (it) {
                    is Resource.Loading -> {
                        Toast.makeText(this@CountryListActivity, "Loading............", Toast.LENGTH_LONG).show()
                    }

                    is Resource.Success -> {
                        Toast.makeText(
                            this@CountryListActivity,
                            "Data ............ ${it.data?.size}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    is Resource.Error -> {
                        Toast.makeText(this@CountryListActivity, "Error............${it.message}", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }
}