package com.example.loginproject.data.api

import com.example.loginproject.data.Constants.BASE_URL
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager

object ApiClient {
    private var instance : Retrofit ?= null

    val okHttpClient = OkHttpClient.Builder()
        .cookieJar(JavaNetCookieJar(CookieManager()))
        .build()





    fun getInstance() : Retrofit{
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return instance!!
    }

   

}