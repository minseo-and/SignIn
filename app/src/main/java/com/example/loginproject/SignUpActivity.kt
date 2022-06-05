package com.example.loginproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)



        var btn_signUp = findViewById<Button>(R.id.btn_make)
        var et_email = findViewById<EditText>(R.id.et_make_email)
        var et_password = findViewById<EditText>(R.id.et_make_password)

        btn_signUp.setOnClickListener {

            if (TextUtils.isEmpty(et_email.text.toString())||TextUtils.isEmpty(et_password.text.toString())){
                Toast.makeText(applicationContext, "빈칸을 채워주세요", Toast.LENGTH_SHORT).show()
            }
            else {
                if ((et_password.text.toString()).length < 8){
                    Toast.makeText(applicationContext, "비밀번호는 8자리 이상입니다", Toast.LENGTH_SHORT).show()
                }

                else {
                    val signUpData = SignUpRequest(
                        email = (et_email.text.toString()),
                        password = (et_password.text.toString())
                    )
                    SignUpUser(signUpData)
                }


            }
        }
    }

    fun SignUpUser(signUpData : SignUpRequest){

        val service  = ApiClient.getInstance().create(ApiService::class.java)
        val call : Call<SignUpResponse> = service.getSignUp(signUpData)

        call.enqueue(object : Callback<SignUpResponse>{
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                if (response.isSuccessful){
                    Toast.makeText(applicationContext, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    Log.d("msg", response.toString())
                    val intent : Intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "회원가입 실패", Toast.LENGTH_SHORT).show()
                Log.d("msg", t.message.toString())
            }

        })



    }
}