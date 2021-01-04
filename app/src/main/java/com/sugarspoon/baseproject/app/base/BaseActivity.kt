package com.sugarspoon.baseproject.app.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.sugarspoon.baseproject.R
import com.sugarspoon.baseproject.utils.extensions.hideKeyboard
import com.sugarspoon.baseproject.utils.extensions.setVisible
import com.sugarspoon.baseproject.utils.extensions.showKeyboard
import com.sugarspoon.baseproject.utils.extensions.toast

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun setToolbar(title: String, displayHomeAsUpEnabled: Boolean) {
        setToolbar(title)
        supportActionBar?.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled)
    }

    fun setToolbar(title: String) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val titleView = findViewById<TextView>(R.id.toolbarTitle)
        if (titleView != null) {
            titleView.setVisible(title.isNotEmpty())
            titleView.text = title
            toolbar.title = " "
        } else {
            toolbar.title = title
        }
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