package com.example.loginproject.signIn

import com.example.loginproject.data.TokenResponse
import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("token")
    val token: TokenResponse
)