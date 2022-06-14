package com.example.loginproject.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var instance : Retrofit ?= null
    private val BASE_URL = "http://3.39.128.31:8888/"


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