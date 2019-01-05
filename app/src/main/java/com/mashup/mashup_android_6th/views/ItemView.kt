package com.mashup.mashup_android_6th.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.mashup.mashup_android_6th.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ItemView @JvmOverloads constructor(
    context : Context,
    attrs : AttributeSet? = null,
    defStyleAttr : Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {
    private val tvName : TextView
    @TextProp lateinit var name : CharSequence

    private val tvCharacter : TextView
    @TextProp lateinit var character : CharSequence

    init {
        View.inflate(context, R.layout.viewholder_item, this)
        tvName = findViewById(R.id.tvName)
        tvCharacter = findViewById(R.id.tvCharacter)
    }

    // tvName 에다가 name을 set 해주는 코드
    @AfterPropsSet
    fun userProps(){
        tvName.text = name
        tvCharacter.text = character
    }
}