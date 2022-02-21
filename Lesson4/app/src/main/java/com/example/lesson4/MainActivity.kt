package com.example.lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        if (savedInstanceState == null) supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment()).commitNow()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}