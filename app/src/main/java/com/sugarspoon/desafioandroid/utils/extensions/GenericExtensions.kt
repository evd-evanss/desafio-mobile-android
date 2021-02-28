package com.sugarspoon.desafioandroid.utils.extensions

import android.content.res.ColorStateList
import android.content.res.TypedArray

fun <T> TypedArray.applyIfPresent(function: (TypedArray.() -> T?), applyBlock: (T) -> Unit) {
    val value = function()
    if (value != null && (value !is Number || (value as Number).toInt() != -1)) {
        applyBlock.invoke(value)
    }
}

fun Int.toStateList() = ColorStateList.valueOf(this)