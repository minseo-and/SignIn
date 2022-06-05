package com.example.loginproject

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @POST("auth/register/")
    fun getSignUp(@Body signUpRequest: SignUpRequest) : Call<SignUpResponse>

    @PUT("auth/login/")
    fun getSignIn(@Body signInRequest: SignInRequest) : Call<SignInResponse>
}