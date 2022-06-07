package com.example.loginproject

data class SignUpRequest(
    val email: String,
    val password: String,
    val entranceYear : Int
)