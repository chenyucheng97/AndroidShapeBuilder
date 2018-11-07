package com.unicorn.androidshapebuilder

fun shapeDSLBuilder(init: SuperBackgroundDrawable.Builder.() -> Unit): SuperBackgroundDrawable =
    SuperBackgroundDrawable.Builder().apply { init() }.build()

fun shapeBuilder(init: SuperBackgroundDrawable.() -> Unit) = SuperBackgroundDrawable().apply { init() }