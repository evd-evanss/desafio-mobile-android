package com.sugarspoon.baseproject.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.sugarspoon.baseproject.R
import kotlinx.android.synthetic.main.layout_button.view.*

class BaseButton: FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_button, this, true)
    }

    fun setText(text: String) {
        baseBt.text = text
    }
}