package com.example.myapp.mynearbuygetter

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapp.mynearbuygetter.database.AppDatabase
import com.example.myapp.mynearbuygetter.entity.RegisterEntity
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class RegistrationActivity : AppCompatActivity() {

    @BindView(R.id.btn_reg_register) lateinit var btnRegister: Button
    @BindView(R.id.edt_reg_phonenum) lateinit var edtPhoneNum: EditText


    private var appDatabase: AppDatabase?= null
    val compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        ButterKnife.bind(this)
        appDatabase = AppDatabase.getInstance(this)!!

        this.btnRegister.setOnClickListener{
            var phoneNumber=edtPhoneNum.text
            val registerEntity=RegisterEntity(phoneNumber.toString())
            InsertToDb(this,registerEntity).execute()
        }
    }

    private class InsertToDb(var context:RegistrationActivity,var registerEntity: RegisterEntity) :AsyncTask<Void,Void,Boolean>(){
        override fun doInBackground(vararg params: Void?): Boolean {
            context.appDatabase?.registerDao()?.insertAll(registerEntity)
            return true
        }

        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "Added to Database", Toast.LENGTH_LONG).show()
            }
        }


    }
}
