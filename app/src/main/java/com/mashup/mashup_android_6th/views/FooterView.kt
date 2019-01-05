package com.mashup.mashup_android_6th.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.mashup.mashup_android_6th.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class FooterView @JvmOverloads constructor(
    context : Context,
    attrs : AttributeSet? = null,
    defStyleAttr : Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.viewholder_footer, this)
    }
}