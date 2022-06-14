package com.example.loginproject.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.SharedPreferences
import com.example.loginproject.MainActivity
import com.example.loginproject.R
import com.example.loginproject.signUp.SignUpActivity
import com.example.loginproject.data.api.ApiClient
import com.example.loginproject.data.api.ApiService
import retrofit2.create


class SignInActivity : AppCompatActivity() {
    private val preferences: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val tv_go = findViewById<TextView>(R.id.tv_sighUp)

        val et_email = findViewById<EditText>(R.id.et_login_email)
        val et_password = findViewById<EditText>(R.id.et_login_password)
        val btn_login = findViewById<Button>(R.id.btn_done)


        tv_go.setOnClickListener {
            val intent : Intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            if (TextUtils.isEmpty(et_email.text.toString())|| TextUtils.isEmpty(et_password.text.toString())){
                Toast.makeText(applicationContext, "빈칸을 채워주세요", Toast.LENGTH_SHORT).show()
            }
            else {
                if ((et_password.text.toString()).length < 2){
                    Toast.makeText(applicationContext, "비밀번호는 8자리 이상입니다", Toast.LENGTH_SHORT).show()
                }

                else {
                    val signInData = SignInRequest(
                        email = (et_email.text.toString()),
                        password = (et_password.text.toString())
                    )
                    loginUser(signInData)
                }
            }
        }


    }


    fun loginUser(signInData : SignInRequest){

        val service = ApiClient.getInstance().create(ApiService::class.java)
        val call : Call<SignInResponse> = service.getSignIn(signInData)

        call.enqueue(object : Callback<SignInResponse> {
            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                if (response.isSuccessful){
                    Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                    Log.d("msg", response.toString())
                    Log.d("msg", response.headers().toString())
                    Log.d("msg", response.headers().get("Set-Cookie").toString())

                    val intent : Intent = Intent(this@SignInActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else if (response.code() == 401){
                    Toast.makeText(applicationContext, "로그인 실패 다시 시도하세요", Toast.LENGTH_SHORT).show()

                }
                else {
                    Log.d("msg", response.toString())
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "로그인 실패", Toast.LENGTH_SHORT).show()
                Log.d("msg", t.message.toString())
            }


        })
    }

}