package com.example.loginproject

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @POST("auth/sign-up/")
    fun getSignUp(@Body signUpRequest: SignUpRequest) : Call<SignUpResponse>

    @POST("auth/sign-in/")
    fun getSignIn(@Body signInRequest: SignInRequest) : Call<SignInResponse>
}