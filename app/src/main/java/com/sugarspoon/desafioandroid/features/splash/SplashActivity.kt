package com.sugarspoon.desafioandroid.features.splash

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.sugarspoon.desafioandroid.base.BaseActivity
import com.sugarspoon.desafioandroid.features.main.MainActivity
import com.sugarspoon.desafioandroid.databinding.ActivitySplashBinding
import com.sugarspoon.desafioandroid.utils.extensions.finishSplashActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun getViewBinding() = ActivitySplashBinding.inflate(layoutInflater)

    override fun onStart() {
        super.onStart()
        finishSplashActivity(
            lifecycleCoroutineScope = lifecycleScope,
            intent = Intent(this, MainActivity::class.java)
        )
    }
}