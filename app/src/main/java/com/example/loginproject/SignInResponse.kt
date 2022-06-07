package com.example.loginproject

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("token")
    val token: TokenResponse
)