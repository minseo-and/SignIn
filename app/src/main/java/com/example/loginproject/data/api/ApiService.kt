package com.example.loginproject.data.api

import com.example.loginproject.data.Constants.REFRESH
import com.example.loginproject.data.Constants.SIGN_IN
import com.example.loginproject.data.Constants.SIGN_UP
import com.example.loginproject.signIn.SignInRequest
import com.example.loginproject.signIn.SignInResponse
import com.example.loginproject.signUp.SignUpRequest
import com.example.loginproject.signUp.SignUpResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST(SIGN_UP)
    fun getSignUp(@Body signUpRequest: SignUpRequest) : Call<SignUpResponse>

    @POST(SIGN_IN)
    fun getSignIn(@Body signInRequest: SignInRequest) : Call<SignInResponse>

    @PUT(REFRESH)
    fun getRefresh(@Header("Authorization") authToken : String): Call<Void>
}