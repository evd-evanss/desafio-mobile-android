package com.sugarspoon.baseproject.app.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.sugarspoon.baseproject.R
import com.sugarspoon.baseproject.app.base.BaseActivity
import com.sugarspoon.baseproject.utils.extensions.safeCollect
import com.sugarspoon.baseproject.utils.extensions.setVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar(getString(R.string.app_name))
        setupListeners()
        setupUiCollectors()
    }

    private fun setupUiCollectors() {
        viewModel.state.observe(this, Observer {

        })
    }

    private fun setupListeners() {
        mainRouterBt.setOnClickListener {
            viewModel.handle(MainViewIntent.ClickButton)
        }
    }
}