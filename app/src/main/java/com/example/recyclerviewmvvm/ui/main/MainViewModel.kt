package com.example.recyclerviewmvvm.ui.main

import CountryInfo_Base
import Rows
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewmvvm.data.network.CountryApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var mutableData:MutableLiveData<CountryInfo_Base> = MutableLiveData()
    init{
        // call  Rest API in init method
        init()
    }
    private fun init() {
        val apiInterface = CountryApi.invoke().getCountryInfo();
        apiInterface.enqueue( object : Callback<CountryInfo_Base> {
            override fun onResponse(call: Call<CountryInfo_Base>?, response: Response<CountryInfo_Base>?) {
                if(response?.body() != null)
                    mutableData.setValue(response.body())
            }
            override fun onFailure(call: Call<CountryInfo_Base>?, t: Throwable?) {

            }
        })

    }

}