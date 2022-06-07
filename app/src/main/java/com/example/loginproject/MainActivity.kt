package com.example.loginproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_signOut = findViewById<Button>(R.id.btn_signOut)

        btn_signOut.setOnClickListener {
            sign_out()
        }
    }

    fun sign_out(){
        val intent : Intent = Intent(this@MainActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}