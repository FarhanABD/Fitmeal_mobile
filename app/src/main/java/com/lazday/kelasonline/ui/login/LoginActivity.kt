package com.lazday.kelasonline.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.lazday.kelasonline.ui.BaseActivity
import com.lazday.kelasonline.ui.home.HomeActivity
import com.lazday.kelasonline.databinding.ActivityLoginBinding
import com.lazday.kelasonline.preferences.PrefManager
import com.lazday.kelasonline.network.ApiClient

class LoginActivity : BaseActivity(), LoginView {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = LoginPresenter (
                this,
                PrefManager(this),
                ApiClient.getService()
        )
    }

    override fun setupListener() {


        binding.editEmail.setText( "budi@gmail.com" )
        binding.editPassword.setText( "budi@gmail.com" )

        binding.buttonLogin.setOnClickListener {
            presenter.fetchLogin(
                    binding.editEmail.text.toString(),
                    binding.editPassword.text.toString()
            )
        }
    }

    override fun loginLoading(loading: Boolean) {
        binding.buttonLogin.isEnabled = loading.not()
        when (loading ) {
            true -> binding.buttonLogin.text = "Tunggu.."
            false -> binding.buttonLogin.text = "Masuk"
        }
    }

    override fun loginResponse( response: LoginResponse ) {
        if (response.status) {
            Toast.makeText(applicationContext, response.msg, Toast.LENGTH_SHORT).show()
            presenter.saveSession( response.data!!, binding.editPassword.text.toString() )
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext, response.msg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun loginError(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        loginLoading(false)
    }
}