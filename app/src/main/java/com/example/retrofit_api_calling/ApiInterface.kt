package com.example.retrofit_api_calling

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("all")

    fun getallcountry():retrofit2.Call<List<CountryModel2>>
    fun getAllCountry(): Call<List<CountryModel2>>

}