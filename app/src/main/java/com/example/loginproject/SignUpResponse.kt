package com.example.loginproject

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("status")
    val status: String?
)