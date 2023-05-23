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