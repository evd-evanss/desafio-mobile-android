package com.sugarspoon.desafioserasa.app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.sugarspoon.desafioserasa.utils.extensions.hideKeyboard
import com.sugarspoon.desafioserasa.utils.extensions.showKeyboard
import com.sugarspoon.desafioserasa.utils.extensions.toast

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<Binding : ViewBinding>(
    private val inflate: Inflate<Binding>
) : Fragment() {

    private var _binding: Binding? = null
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

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