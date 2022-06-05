package com.example.loginproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var instance : Retrofit ?= null
    private val BASE_URL = "http://122.34.166.47:3000/"


    fun getInstance() : Retrofit{
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return instance!!
    }

}