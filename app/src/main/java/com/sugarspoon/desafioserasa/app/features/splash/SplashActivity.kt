package com.sugarspoon.desafioserasa.app.features.splash

import android.content.Intent
import com.sugarspoon.desafioserasa.app.base.BaseActivity
import com.sugarspoon.desafioserasa.app.features.main.MainActivity
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