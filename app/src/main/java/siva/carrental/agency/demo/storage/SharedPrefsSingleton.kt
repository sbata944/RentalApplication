package siva.carrental.agency.demo.storage

import android.R
import android.content.Context
import android.content.SharedPreferences


/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/12/2024.
 *
 */
class SharedPrefsSingleton {
    private var sharedPref: SharedPreferences? = null
    private var appContext: Context? = null

    private var instance: SharedPrefsSingleton? = null


    fun getInstance(applicationContext: Context): SharedPrefsSingleton? {
        if (instance == null) instance = SharedPrefsSingleton(applicationContext)
        return instance as SharedPrefsSingleton
    }

    private fun SharedPrefsSingleton(applicationContext: Context): SharedPrefsSingleton? {
        appContext = applicationContext
        sharedPref = appContext!!.getSharedPreferences(
            appContext!!.getString(R.string.copyUrl), Context.MODE_PRIVATE
        )
        return TODO("Provide the return value")
    }

    fun updateUserNamePwd(username: String, password: String){
        val editor = sharedPref!!.edit()
        editor.putString("UserName", username)
        editor.putString("Password", password)
        editor.apply()
    }

    fun getUserName(): Float {
        return sharedPref!!.getFloat("UserName", 0f)
    }

    fun getPassword(): Float {
        return sharedPref!!.getFloat("Password", 0f)
    }
}