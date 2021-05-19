package com.mobile.umentoring.pref

import android.content.Context
import android.content.SharedPreferences

import com.mobile.umentoring.view.LoginFragment


class PreferencesHelper(context: Context) {
    private val PREFS_NAME = "loginsharedpreference"
    private lateinit var sharedpref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        //mode private agar hanya project ini yang menggunakan sharedpreferences
        sharedpref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedpref.edit()
    }

    //menyimpan data pada sharedpref
    fun put (key: String, value: String){
        //simpan key dan value
        editor.putString(key, value)
            .apply()
    }

    //untuk mendapatkan nilai
    fun getString(key: String): String?{
        return sharedpref.getString(key, null)
    }


    //menyimpan data pada sharedpref boolean
    fun put (key: String, value: Boolean){
        //simpan key dan value
        editor.putBoolean(key, value)
            .apply()
    }

    //untuk mendapatkan nilai boolean
    fun getBoolean(key: String): Boolean?{
        return sharedpref.getBoolean(key, false)
    }

    fun logout(){
        editor.clear()
        editor.commit()
    }

}