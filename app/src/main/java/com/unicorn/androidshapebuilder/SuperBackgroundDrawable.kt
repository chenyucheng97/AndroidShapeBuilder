package com.unicorn.androidshapebuilder

import android.graphics.drawable.GradientDrawable

class SuperBackgroundDrawable : GradientDrawable() {

    /**
     * 设置shape的type类型为[type] , 可选值 ：0 = RECTANGLE,1=OVAL,LINE,RING
     */
    fun type(type: Int) = apply { shape = type }

    /**
     * 设置描边，宽度值px为[px]，颜色为[color]
     */
    fun stroke(px: Int, color: Int) = apply { setStroke(px, color) }


    /**
     * 设置描边，宽度值px为[px]，颜色为[color], 线宽为[dashWidth]，线间距为[dashGap]
     */
    fun stroke(px: Int, color: Int, dashWidth: Float, dashGap: Float) =
        apply { setStroke(px, color, dashWidth, dashGap) }

    /**
     * 设置背景颜色为[color]
     */
    fun solid(color: Int) = apply { setColor(color) }

    /**
     * 设置px值为[px]的四个圆角
     */
    fun radius(px: Float) = apply { cornerRadius = px }

    /**
     * 设置左上px值为[topLeft]，右下px值为[botRight]等的四个圆角
     */
    fun radius(topLeft: Float, topRight: Float, botLeft: Float, botRight: Float) = apply {
        cornerRadii = floatArrayOf(topLeft, topLeft, topRight, topRight, botLeft, botLeft, botRight, botRight)
    }

    /**
     * 添加一个Builder ，可以使用DSL语法构建drawable
     */
    class Builder {

        var shapeType: Int = 0
        var strokeWidth: Int = 0
        var strokeColor: Int = 0
        var solidColor: Int = 0
        var radius: Float = 0f
        var topLeftRadius = 0f
        var topRightRadius = 0f
        var botLeftRadius = 0f
        var botRightRadius = 0f

        fun build(): SuperBackgroundDrawable {
            val drawable = SuperBackgroundDrawable().apply {
                shape = shapeType
                setStroke(strokeWidth, strokeColor)
                setColor(this@Builder.solidColor)
                cornerRadius = radius
                if (topLeftRadius > 0f) {
                    cornerRadii = floatArrayOf(
                        topLeftRadius,
                        topLeftRadius,
                        topRightRadius,
                        topRightRadius,
                        botLeftRadius,
                        botLeftRadius,
                        botRightRadius,
                        botRightRadius
                    )
                }
            }
            return drawable
        }
    }

}