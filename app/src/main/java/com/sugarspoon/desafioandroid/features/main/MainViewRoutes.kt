package com.sugarspoon.desafioandroid.features.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

internal data class MainViewRoutes(
    val activity: AppCompatActivity,
    private val routeSplash: AppCompatActivity? = null
) {
    fun navigateToSplash() {
        routeSplash?.run {
            activity.startActivity(Intent(activity, this::class.java))
        }
    }
}