package com.sugarspoon.baseproject.app.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sugarspoon.baseproject.utils.extensions.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<Intent, State> : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    protected val _state = SingleLiveEvent<State>()
    val state: LiveData<State> = _state

    abstract fun handle(intent: Intent)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
