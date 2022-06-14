package com.example.loginproject.data.api

import com.example.loginproject.signIn.SignInRequest
import com.example.loginproject.signIn.SignInResponse
import com.example.loginproject.signUp.SignUpRequest
import com.example.loginproject.signUp.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("auth/sign-up/")
    fun getSignUp(@Body signUpRequest: SignUpRequest) : Call<SignUpResponse>

    @POST("auth/sign-in/")
    fun getSignIn(@Body signInRequest: SignInRequest) : Call<SignInResponse>


}