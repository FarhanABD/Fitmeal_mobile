package com.lazday.kelasonline.util

import com.google.gson.Gson
import com.lazday.kelasonline.preferences.PrefManager
import com.lazday.kelasonline.ui.login.LoginData

fun userLogin (pref: PrefManager) : LoginData {
    val json = pref.getString( "user_login")
    return Gson().fromJson(json, LoginData::class.java )
}