package com.example.recyclerviewmvvm.data.network

import CountryInfo_Base
import Rows
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountryApi {
@GET("facts.json")
 fun getCountryInfo():Call<CountryInfo_Base>

    companion object{
        fun invoke(): CountryApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                .build()
                .create(CountryApi::class.java)
        }
    }
}