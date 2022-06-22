package com.example.loginproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginproject.data.App
import com.example.loginproject.data.api.ApiClient
import com.example.loginproject.data.api.ApiService
import com.example.loginproject.signIn.SignInActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_signOut = findViewById<Button>(R.id.btn_signOut)

        btn_signOut.setOnClickListener {

        }

        val btn_go = findViewById<Button>(R.id.btn_go_login)
        btn_go.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }




}