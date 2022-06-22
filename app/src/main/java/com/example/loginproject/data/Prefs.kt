package com.example.loginproject.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(context: Context) {
    private val prefNm="mPref"
    private val prefs=context.getSharedPreferences(prefNm,MODE_PRIVATE)

    var token:String?
        get() = prefs.getString("token",null)
        set(value){
            prefs.edit().putString("token",value).apply()
        }

    var email:String?
        get() = prefs.getString("email",null)
        set(value) {
            prefs.edit().putString("email",value).apply()
        }

    var password:String?
        get() = prefs.getString("password",null)
        set(value) {
            prefs.edit().putString("password",value).apply()
        }

}