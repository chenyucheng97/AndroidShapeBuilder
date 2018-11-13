package com.unicorn.androidshapebuilder

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 链式调用方式定义对象
         */
        val shapeBuilder1 = SuperBackgroundDrawable().radius(35f).stroke(5, Color.BLACK).solid(Color.RED)

        /**
         * 使用标准库函数方式定义对象
         */
        val shapeBuilder2 = SuperBackgroundDrawable().apply {
            radius(10000f)
            stroke(5, Color.BLACK)
            solid(Color.YELLOW)
        }

        /**
         * DSL方式定义对象
         */
        val shapeBuilder3 = shapeDSLBuilder {
            radius = 35f
            strokeWidth = 5
            strokeColor = Color.BLACK
            solidColor = Color.LTGRAY
        }


        /**
         * lambda方式定义对象
         */
        val shapeBuilder4 = shapeBuilder {
            radius(35f)
            solid(Color.GREEN)
        }

        /**
         * DSL方式定义对象
         */
        val shapeBuilder5 = shapeDSLBuilder {
            topLeftRadius = 35f
            topRightRadius = 0f
            botLeftRadius = 35f
            botRightRadius = 0f
            strokeWidth = 5
            strokeColor = Color.BLACK
            solidColor = Color.BLUE
        }

        textView0.background = shapeBuilder1
        textView1.background = shapeBuilder2
        textView2.background = shapeBuilder3
        textView3.background = shapeBuilder4
        textView4.background = shapeBuilder5
    }
}

