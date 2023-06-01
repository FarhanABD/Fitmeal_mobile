package com.lazday.kelasonline.ui.login

import java.io.Serializable

data class LoginResponse (
        val status: Boolean,
        val msg: String,
        val data: LoginData?
    )

data class LoginData (
        val id: Int,
        val email: String,
        val password: String,
        val name: String,
        val gender: String,
        val phone: String,
        val avatar: String,
    ) : Serializable

//data class LoginData (
//        val id: Int,
//        val email: String,
//        val password: String,
//        val name: String,
//        val gender: String,
//        val phone: String,
//        val nik:String,
//        val address:String,
//        val gejala:String,
//        val diagnosis:String,
//        val berat_badan:Int,
//        val tinggi_badan:Int,
//        val usia:Int,
//        val avatar: String,
//) : Serializable