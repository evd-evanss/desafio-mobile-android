package com.sugarspoon.baseproject.app.ui.splash

import android.content.Intent
import android.os.Bundle
import com.sugarspoon.baseproject.R
import com.sugarspoon.baseproject.app.base.BaseActivity
import com.sugarspoon.baseproject.app.ui.main.MainActivity
import com.sugarspoon.baseproject.utils.extensions.finishSplashActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        finishSplashActivity(Intent(this, MainActivity::class.java))
    }
}