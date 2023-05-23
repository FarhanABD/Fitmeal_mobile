package com.lazday.kelasonline.ui.home

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.lazday.kelasonline.R
import com.lazday.kelasonline.databinding.ActivityHomeBinding
import com.lazday.kelasonline.ui.BaseActivity

class HomeActivity : BaseActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.navView.setupWithNavController(
            findNavController(R.id.nav_host_fragment)
        )
    }
}