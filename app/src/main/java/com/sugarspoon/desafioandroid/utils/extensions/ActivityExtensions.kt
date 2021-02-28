package com.sugarspoon.desafioandroid.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import com.sugarspoon.desafioandroid.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.Serializable

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Activity.hideKeyboard() {
    currentFocus?.let {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }
}

fun Context.showKeyboard() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

fun Activity.finishSplashActivity(
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    intent: Intent,
) {
    lifecycleCoroutineScope.launch {
        delay(3000)
        startActivitySlideTransition(intent = intent, finalize = true)
    }
}

fun Activity.startActivitySlideTransition(
    intent: Intent,
    finalize: Boolean = false,
    requestCode: Int? = null
) {
    startActivityTransition(
        intent = intent, idAnimationOut = R.anim.anim_close_scale,
        idAnimationIn = R.anim.slide_in_left,
        delay = 1,
        requestCode = requestCode
    )
    if(finalize) this.finish()
}

fun Fragment.startActivitySlideTransition(
    intent: Intent,
    requestCode: Int? = null
) {
    activity?.startActivityTransition(
        intent = intent,
        idAnimationOut = R.anim.anim_close_scale,
        idAnimationIn = R.anim.slide_in_left,
        delay = 1,
        requestCode = requestCode
    )
}

fun Activity.startActivityTransition(
    intent: Intent,
    idAnimationOut: Int,
    idAnimationIn: Int,
    delay: Long,
    requestCode: Int? = null
) {
    if (requestCode == null) {
        Handler().postDelayed({
            this.startActivity(intent)
            this.overridePendingTransition(idAnimationIn, idAnimationOut)
        }, delay)
    } else {
        Handler().postDelayed({
            this.startActivityForResult(intent, requestCode)
            this.overridePendingTransition(idAnimationIn, idAnimationOut)
        }, delay)
    }
}

fun <T : Serializable?> Activity.getSerializable(key: String): T {
    return intent.getSerializableExtra(key) as T
}

fun Context.getColorRes(idRes: Int): Int {
    return ContextCompat.getColor(this, idRes)
}