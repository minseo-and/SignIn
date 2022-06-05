package com.example.loginproject

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/register/")
    fun getSignUp(@Body signUpRequest: SignUpRequest) : Call<SignUpResponse>

    @POST("auth/login/")
    fun getSignIn(@Body signInRequest: SignInRequest) : Call<SignInResponse>
}