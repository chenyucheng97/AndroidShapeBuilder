package com.unicorn.androidshapebuilder

inline fun shapeDSLBuilder(init: SuperBackgroundDrawable.Builder.() -> Unit): SuperBackgroundDrawable =
    SuperBackgroundDrawable.Builder().apply { init() }.build()

inline fun shapeBuilder(init: SuperBackgroundDrawable.() -> Unit) = SuperBackgroundDrawable().apply { init() }