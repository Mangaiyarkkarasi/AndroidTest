package com.example.myapp.mynearbuygetter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife

class LoginActivity : AppCompatActivity() {

    @BindView(R.id.edt_username) lateinit var edtUserName: EditText
    @BindView(R.id.edt_password) lateinit var edtPassword: EditText
    @BindView(R.id.btn_login) lateinit var btnLogin: Button
    @BindView(R.id.btn_register) lateinit var btnRegister: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
        this.btnRegister.setOnClickListener{
            var intent=Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }



    }
}
