package com.mobile.umentoring.pref

import android.content.Context
import android.content.SharedPreferences

class SessionManager(val context : Context?) {

    var pref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var PREF_NAME = "LoginRegister"

    var PREF_IS_LOGIN = "isLogin"
    var PREF_ID = "id"
    var PREF_PART_ID = "participant_id"
    var PREF_EMAIL = "email"

    init {
        pref = context?.getSharedPreferences(PREF_NAME, 0)
        editor = pref?.edit()
    }

    var login: Boolean?
        get() = pref?.getBoolean(PREF_IS_LOGIN, false)
        set(login) {
            editor?.putBoolean(PREF_IS_LOGIN, true)
            editor?.commit()
        }

    var id: Int?
        get() = pref?.getInt(PREF_ID, 0)
        set(id) {
            editor?.putInt(PREF_ID, id?:0)
            editor?.commit()
        }

    var participant_id: Int?
        get() = pref?.getInt(PREF_PART_ID, 0)
        set(id) {
            editor?.putInt(PREF_PART_ID, id?:0)
            editor?.commit()
        }

    fun logout(){
        editor?.clear()
        editor?.commit()
    }





}