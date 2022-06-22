package com.example.loginproject.signIn

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginproject.MainActivity
import com.example.loginproject.R
import com.example.loginproject.data.App
import com.example.loginproject.data.api.ApiClient
import com.example.loginproject.data.api.ApiService
import com.example.loginproject.signUp.SignUpActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInActivity : AppCompatActivity() {

    val service = ApiClient.getInstance().create(ApiService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val tv_go = findViewById<TextView>(R.id.tv_sighUp)

        val et_email = findViewById<EditText>(R.id.et_login_email)
        val et_password = findViewById<EditText>(R.id.et_login_password)
        val btn_login = findViewById<Button>(R.id.btn_done)


        tv_go.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
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

        val call : Call<SignInResponse> = service.getSignIn(signInData)


        call.enqueue(object : Callback<SignInResponse> {


            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                if (response.isSuccessful){


                    val token : String
                    Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                    val Cookielist = response.headers().values("Set-Cookie")
                    Log.d("msg", response.toString())
                    Log.d("msp",response.body().toString())
                    Log.d("msg", response.headers().toString())
                    Log.d("msg", Cookielist[0])
                    token = Cookielist[0]
                    val str:String = token.substring(12, token.indexOf(";"))



                    Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
                    App.prefs.token = str
                    App.prefs.email = signInData.email
                    App.prefs.password = signInData.password


                    val intent = Intent(this@SignInActivity, MainActivity::class.java)
                    intent.putExtra("token", Cookielist[0])
                    startActivity(intent)
                    finish()
                }
                else if (response.code() == 401){
                    Toast.makeText(applicationContext, "로그인 실패 다시 시도하세요", Toast.LENGTH_SHORT).show()
                    refresh()
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

    fun refresh(){
        val token = App.prefs.token.toString()
        println(token)
        Toast.makeText(applicationContext,token,Toast.LENGTH_SHORT).show()
        val service = ApiClient.getInstance().create(ApiService::class.java)
        val call : Call<Void> = service.getRefresh(authToken = "Bearer ${App.prefs.token}")
        call.enqueue(object :Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful){
                    Log.d("msp", App.prefs.token.toString())
                    Toast.makeText(applicationContext,"성공",Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("msp", App.prefs.token.toString())
                    Toast.makeText(applicationContext,response.code().toString(),Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext,"실패",Toast.LENGTH_SHORT).show()
            }

        })

    }

}