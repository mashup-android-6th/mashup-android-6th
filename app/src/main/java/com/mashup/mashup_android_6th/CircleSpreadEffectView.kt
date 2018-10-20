package com.mashup.mashup_android_6th

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator

class CircleSpreadEffectView: View {

    private val paint: Paint = Paint()
    private val animator = ValueAnimator.ofInt(0, 1)

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        animator.duration = 3000
        animator.addUpdateListener {
            postInvalidate()
        }
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        resetPaint()
        val (cx, cy) = width / 2f to height / 2f
        val maxRadius = width / 2f
        val radius = maxRadius * animator.animatedFraction

        canvas?.drawCircle(cx, cy, if (radius > maxRadius) maxRadius else radius, paint)
    }


    private fun resetPaint() {
        paint.reset()

        paint.color = Color.parseColor("#7382C8")
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = false
        paint.alpha = (255 * (1 - animator.animatedFraction)).toInt()
    }

}