package com.sugarspoon.baseproject.app.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.sugarspoon.baseproject.app.base.BaseViewModel
import com.sugarspoon.baseproject.utils.extensions.onCollect
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

internal class MainViewModel @ViewModelInject constructor(): BaseViewModel<MainViewIntent, MainViewState>() {

    override fun handle(intent: MainViewIntent) {

    }
}

