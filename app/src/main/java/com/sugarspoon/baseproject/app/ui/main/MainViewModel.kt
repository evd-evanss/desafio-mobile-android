package com.sugarspoon.baseproject.app.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import com.sugarspoon.baseproject.app.base.BaseViewModel

internal class MainViewModel @ViewModelInject constructor(): BaseViewModel<MainViewState, MainViewRoutes>() {

    override val initialViewState: MainViewState
        get() = MainViewState(loading = false)

    override fun navigateByRoute(routes: MainViewRoutes) {
        routes.navigateToSplash()
    }

    fun displayLoading(isVisible: Boolean) {
        state.value = MainViewState(loading = isVisible)
    }

    fun changeTitle(text: Int) {
        state.value = MainViewState(textTitle = text)
    }
}

