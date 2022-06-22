package com.example.loginproject.signIn

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("message")
    val message: String,

)