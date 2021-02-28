package com.sugarspoon.desafioserasa.features.splash

import android.content.Intent
import com.sugarspoon.desafioserasa.base.BaseActivity
import com.sugarspoon.desafioserasa.features.main.MainActivity
import com.sugarspoon.desafioserasa.databinding.ActivitySplashBinding
import com.sugarspoon.desafioserasa.utils.extensions.finishSplashActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun getViewBinding() = ActivitySplashBinding.inflate(layoutInflater)

    override fun onStart() {
        super.onStart()
        finishSplashActivity(Intent(this, MainActivity::class.java))
    }
}