package com.example.lesson4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.bottomNavigation?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.main->{
                    supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment()).commitNow()
                    }
                R.id.timetable->{
                    supportFragmentManager.beginTransaction().replace(R.id.container,TimetableFragment()).commitNow()
                    }
            }
            true
        }
        if (savedInstanceState == null) supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment()).commitNow()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}