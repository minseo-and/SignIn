package com.example.loginproject.data.DTO

import com.google.gson.annotations.SerializedName

data class TokenCheck (
    @SerializedName("message")
    val accessToken : String
)