# AndroidShapeBuilder
参考自：https://github.com/jaychang0917/SimpleText
&nbsp;
一个自定义的TextView，对background的设置进行了简单封装。同时包含了一个ShapeBuilder，可以用于设置给所有View添加背景

简化View的background创建，支持在xml和代码中设置backgroundDrawable,  代码中支持链式调用，或者DSL创建

支持在xml和代码中设置View的background
&nbsp;

![效果图：](https://github.com/chenyucheng97/AndroidShapeBuilder/blob/master/WechatIMG199.jpeg)


&nbsp;
xml设置方式：
``` xml
    <com.unicorn.androidshapebuilder.MyTextView
            android:text="textView5"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:padding="10dp"
            android:layout_marginTop="20dp"
            android:layout_marginLeft="20dp"

            app:soildBac="@android:color/holo_green_light"
            app:strokeColor="@android:color/holo_red_light"
            app:strokeWidth="2dp"

            app:radiusBottomLeft="15dp"
            app:radiusBottomRight="2dp"
            app:radiusTopLeft="15dp"
            app:radiusTopRight="8dp"
            android:id="@+id/textView5"/>

``` 

&nbsp;
代码中设置方式：
``` kotlin
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
         * 工具类方式定义对象
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
``` 
