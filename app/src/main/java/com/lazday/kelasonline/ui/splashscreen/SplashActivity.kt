package com.lazday.kelasonline.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.lazday.kelasonline.ui.BaseActivity
import com.lazday.kelasonline.R
import com.lazday.kelasonline.preferences.PrefManager
import com.lazday.kelasonline.ui.home.HomeActivity
import com.lazday.kelasonline.ui.login.LoginActivity

class SplashActivity : BaseActivity(), SplashView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        SplashPresenter(this, PrefManager(this))
    }

    override fun nextPage(isLogin: Int) {
        Handler(Looper.myLooper()!!).postDelayed({
            when (isLogin) {
                1 ->  startActivity(Intent(this, HomeActivity::class.java))
                else -> startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 1500)
    }
}