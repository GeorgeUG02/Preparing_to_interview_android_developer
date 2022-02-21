package com.example.lesson4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson4.databinding.FragmentTimetableBinding

class TimetableFragment : Fragment() {
    private var binding:FragmentTimetableBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimetableBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onDestroy() {
        binding=null
        super.onDestroy()
    }
}