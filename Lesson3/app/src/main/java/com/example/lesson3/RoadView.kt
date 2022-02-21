package com.example.lesson3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RoadView : View {
    private val p: Paint = Paint()

    init {
        p.setColor(Color.BLACK)
        p.strokeWidth = 1f
    }

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f, 0f, 690f, 0f, p)
        canvas?.drawLine(690f, 0f, 690f, 700f, p)

    }
}