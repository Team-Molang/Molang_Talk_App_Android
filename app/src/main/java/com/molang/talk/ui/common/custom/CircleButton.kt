package com.molang.talk.ui.common.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.molang.talk.R
import com.molang.talk.databinding.CustomCircleButtonBinding

class CircleButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var buttonText: String = ""
        set(value) {
            field = value
            binding.tvButtonText.text = value
        }

    val binding: CustomCircleButtonBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.custom_circle_button,
        this,
        true
    )

    init {
        if (attrs != null) {
            val typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.CircleButton, defStyleAttr, 0)
            val circleButtonText: String? = typedArray.getString(R.styleable.CircleButton_cb_text)
            buttonText = circleButtonText ?: ""
            typedArray.recycle()
        }
    }
}