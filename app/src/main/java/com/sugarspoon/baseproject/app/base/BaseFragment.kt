package com.sugarspoon.baseproject.app.base

import androidx.fragment.app.Fragment
import com.sugarspoon.baseproject.utils.extensions.hideKeyboard
import com.sugarspoon.baseproject.utils.extensions.showKeyboard
import com.sugarspoon.baseproject.utils.extensions.toast

abstract class BaseFragment(layoutRes: Int) : Fragment(layoutRes) {

    fun showToast(string: String) {
        activity?.toast(string)
    }

    fun hideSoftKeyboard() {
        activity?.hideKeyboard()
    }

    fun showSoftKeyBoard() {
        activity?.showKeyboard()
    }
}