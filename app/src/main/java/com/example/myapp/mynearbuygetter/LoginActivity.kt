package com.example.myapp.mynearbuygetter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapp.mynearbuygetter.util.AppUtil

class LoginActivity : AppCompatActivity() {

    @BindView(R.id.edt_username) lateinit var edtUserName: EditText
    @BindView(R.id.edt_password) lateinit var edtPassword: EditText
    @BindView(R.id.btn_login) lateinit var btnLogin: Button
    @BindView(R.id.btn_register) lateinit var btnRegister: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("*****check","LL Inside on Create")

        ButterKnife.bind(this)
        val appUtil=AppUtil()
        this.btnRegister.setOnClickListener{
            var intent=Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }

        this.btnLogin.setOnClickListener{
            val sharedPref=appUtil.getSharedPref(this)
            var password=sharedPref.getString("KEYPASSWORD","xxx")

            if(password.equals(edtPassword.text.toString())){
                    Log.d("****check",password)
                val intent=Intent(this,NavigationActivity::class.java)
                startActivity(intent)
                finish()
                }
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("*****check","LL Inside on pause")

    }



    override fun onResume() {
        super.onResume()
        Log.d("*****check","LL Inside on Resume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("*****check","LL Inside on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("*****check","LL Inside on stop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("*****check","LL Inside on destroy")

    }
}
