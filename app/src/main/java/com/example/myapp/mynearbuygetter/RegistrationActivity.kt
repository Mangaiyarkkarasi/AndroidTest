package com.example.myapp.mynearbuygetter

import android.content.Context
import android.content.SharedPreferences
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapp.mynearbuygetter.database.AppDatabase
import com.example.myapp.mynearbuygetter.entity.RegisterEntity
import com.example.myapp.mynearbuygetter.util.AppUtil
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class RegistrationActivity : AppCompatActivity() {

    @BindView(R.id.btn_reg_register)
    lateinit var btnRegister: Button

    @BindView(R.id.edt_reg_phonenum)
    lateinit var edtPhoneNum: EditText

    @BindView(R.id.edt_reg_name)
    lateinit var edtUserName: EditText

    @BindView(R.id.edt_reg_email)
    lateinit var edtEmail: EditText

    @BindView(R.id.edt_reg_password)
    lateinit var edtPassword: EditText


    /*private var appDatabase: AppDatabase? = null
    val compositeDisposable = CompositeDisposable()

    val appUtil=AppUtil()
*/
    //var sharedPref: SharedPreferences = this.getSharedPreferences("REGISTER_DATA", Context.MODE_PRIVATE)
    //var sharedPref: SharedPreferences =

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        ButterKnife.bind(this)
        //appDatabase = AppDatabase.getInstance(this)!!
        Log.d("*****check","RR Inside on Create")


        val appUtil=AppUtil( )
        this.btnRegister.setOnClickListener {
            var phoneNumber = edtPhoneNum.text
            var userName= edtUserName.text
            var email= edtEmail.text
            var password = edtPassword.text
           // val registerEntity = RegisterEntity(phoneNumber.toString())
            val sharedPref=appUtil.getSharedPref(this)
            val editor: SharedPreferences.Editor = sharedPref.edit();
            editor.putString("KEYNAME",userName.toString())
            editor.putString("KEYEMAIL",email.toString())
            editor.putString("KEYPASSWORD",password.toString())
            editor.putString("KEYPHONENUM",phoneNumber.toString())
            editor.commit();
            // InsertToDb(this,registerEntity).execute()
            Log.d("****check",sharedPref.getString("KEYPASSWORD","xxx"))
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("*****check","RR Inside on pause")

    }



    override fun onResume() {
        super.onResume()
        Log.d("*****check","RR Inside on Resume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("*****check","RR Inside on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("*****check","RR Inside on stop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("*****check","RR Inside on destroy")

    }
}

   /* //insert method
    private class InsertToDb(var context:RegistrationActivity,var registerEntity: RegisterEntity) :AsyncTask<Void,Void,Boolean>(){
        override fun doInBackground(vararg params: Void?): Boolean {
            *//*context.appDatabase?.registerDao()?.insertAll(registerEntity)
            return true
      *//*


        }

        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "Added to Database", Toast.LENGTH_LONG).show()
            }
        }


    }
}*/
