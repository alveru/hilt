package com.example.hilt.ui.splash

import android.content.Intent
import androidx.activity.viewModels
import com.example.hilt.R
import com.example.hilt.databinding.ActivitySplashBinding
import com.example.hilt.ui.base.BaseActivity
import com.example.hilt.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModels()

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun subscribeToViewModel(viewModel: SplashViewModel) {
        viewModel.isLoaded().observe(this, {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        })
    }
}