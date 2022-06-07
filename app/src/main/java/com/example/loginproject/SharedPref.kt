package com.example.loginproject

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object SharedPref {
    val LOGIN_SESSION = "login.session"

    private var sharedPref: SharedPreferences? = null

    fun openSharedPrep(context: Context) {
        this.sharedPref = context.getSharedPreferences(LOGIN_SESSION, Context.MODE_PRIVATE)
    }

}