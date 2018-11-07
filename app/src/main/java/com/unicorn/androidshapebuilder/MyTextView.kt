package com.unicorn.androidshapebuilder

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class MyTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {


    private var type: Int = 0

    private var mRadius: Float = 0f

    private var mRadiusTopLeft: Float = 0f

    private var mRadiusTopRight: Float = 0f

    private var mRadiusBottomLeft: Float = 0f

    private var mRadiusBottomRight: Float = 0f

    private var mStrokeColor: Int = 0

    private var mStrokeWidth: Int = 0

    private var mSoild: Int = 0

    init {
        initAttr(context, attrs, defStyleAttr)
        initShape()
    }

    private fun initAttr(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.MyTextView, defStyleAttr, 0)

        type = array.getInteger(R.styleable.MyTextView_shapeType, 0)
        mRadius = array.getDimensionPixelSize(R.styleable.MyTextView_totalRadius, 0).toFloat()
        mRadiusTopLeft = array.getDimensionPixelSize(R.styleable.MyTextView_radiusTopLeft, 0).toFloat()
        mRadiusTopRight = array.getDimensionPixelSize(R.styleable.MyTextView_radiusTopRight, 0).toFloat()
        mRadiusBottomLeft = array.getDimensionPixelSize(R.styleable.MyTextView_radiusBottomLeft, 0).toFloat()
        mRadiusBottomRight = array.getDimensionPixelSize(R.styleable.MyTextView_radiusBottomRight, 0).toFloat()
        mStrokeColor = array.getColor(R.styleable.MyTextView_strokeColor, -1)
        mStrokeWidth = array.getDimensionPixelOffset(R.styleable.MyTextView_strokeWidth, 0)
        mSoild = array.getColor(R.styleable.MyTextView_soildBac, -1)
        array.recycle()
    }


    private fun initShape() {
        if (mRadius == -0f && mRadiusTopLeft == 0f && mRadiusTopRight == 0f && mRadiusBottomLeft == 0f
            && mRadiusBottomRight == 0f && mStrokeColor == -1 && mStrokeWidth == 0 && mSoild == -1
        ) {
            return
        } else {
            setShape()
        }
    }


    private fun setShape() {
        if (mRadius != 0f) {
            this.background = shapeBuilder {
                radius(mRadius)
                stroke(mStrokeWidth, mStrokeColor)
                solid(mSoild)
            }
        } else {
            this.background = shapeDSLBuilder {
                topLeftRadius = mRadiusTopLeft
                topRightRadius = mRadiusTopRight
                botLeftRadius = mRadiusBottomLeft
                botRightRadius = mRadiusBottomRight
                strokeWidth = mStrokeWidth
                strokeColor = mStrokeColor
                solidColor = mSoild
            }
        }
    }
}