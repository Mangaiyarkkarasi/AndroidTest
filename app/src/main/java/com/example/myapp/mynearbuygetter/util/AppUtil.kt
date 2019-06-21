package com.example.myapp.mynearbuygetter.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

public class AppUtil {

     public fun getSharedPref(context: Context) : SharedPreferences {
        Log.d("cghjj","nbnbm")
        var sharedPref: SharedPreferences = context.getSharedPreferences("REGISTER_DATA", Context.MODE_PRIVATE)
        return sharedPref
    }


    /*fun getSharedPref: SharedPreferences(context:Context){

        var sharedPref: SharedPreferences = this.getSharedPreferences("REGISTER_DATA", Context.MODE_PRIVATE)

    }
*/


}

