package com.sugarspoon.desafioserasa.utils.factorys

import android.content.Context
import com.sugarspoon.desafioserasa.R
import com.sugarspoon.desafioserasa.widget.DefaultDialog

object DefaultDialogFactory {

    fun createSuccess(context: Context, title: String, body: String): DefaultDialog {
        return DefaultDialog(context, title, body)
            .setIcon(R.drawable.ic_success)
            .setBackgroundColor(R.color.success)
            .setLeftText(context.getString(R.string.action_ok))
    }

    fun createError(context: Context, title: String, body: String): DefaultDialog {
        return DefaultDialog(context, title, body)
            .setIcon(R.drawable.ic_error)
            .setBackgroundColor(R.color.error)
            .setLeftText(context.getString(R.string.action_ok))
    }
}