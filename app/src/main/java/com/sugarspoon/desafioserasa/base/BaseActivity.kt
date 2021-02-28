package com.sugarspoon.desafioserasa.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewbinding.ViewBinding
import com.sugarspoon.desafioserasa.R
import com.sugarspoon.desafioserasa.utils.extensions.hideKeyboard
import com.sugarspoon.desafioserasa.utils.extensions.showKeyboard
import com.sugarspoon.desafioserasa.utils.extensions.toast

abstract class BaseActivity< Binding : ViewBinding>: AppCompatActivity() {

    lateinit var binding: Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding = getViewBinding()
        setContentView(binding.root)
    }

    abstract fun getViewBinding(): Binding

    fun setToolbar(title: String, displayHomeAsUpEnabled: Boolean) {
        setToolbar(title)
        supportActionBar?.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled)
    }

    fun setToolbar(title: String) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = title
        setSupportActionBar(toolbar)
    }

    fun showToast(string: String) {
        toast(string)
    }

    fun hideSoftKeyboard() {
        hideKeyboard()
    }

    fun showSoftKeyBoard() {
        showKeyboard()
    }
}