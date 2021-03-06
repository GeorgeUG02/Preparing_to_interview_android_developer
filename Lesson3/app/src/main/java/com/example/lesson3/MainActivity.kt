package com.example.lesson3

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var isMoving: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val car = findViewById<ImageView>(R.id.car)
        car.setOnClickListener {
            if (isMoving) return@setOnClickListener
            isMoving = true
            val anim = AnimationUtils.loadAnimation(this, R.anim.combination)
            it.startAnimation(anim)
            val cs = CoroutineScope(Dispatchers.Default)
            cs.launch {
                delay(12000)
                isMoving = false
            }
        }
    }
}