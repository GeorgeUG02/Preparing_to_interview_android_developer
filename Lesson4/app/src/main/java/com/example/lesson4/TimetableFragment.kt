package com.example.lesson4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson4.databinding.FragmentTimetableBinding
import java.util.*

class TimetableFragment : Fragment() {
    private var binding:FragmentTimetableBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimetableBinding.inflate(layoutInflater)
        return binding?.root
    }
    val onItemSkypeClickListener = object:Classes2Adapter.OnItemSkypeClickListener{
        override fun onCLick() {
            val intent = requireActivity().packageManager.getLaunchIntentForPackage("com.skype.android");
            startActivity(intent)
        }
    }
    lateinit var adapterClasses2:Classes2Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val examDate = Date(122,2,1,10,0)
        val currDate = Date()
        val diffDays = (examDate.time-currDate.time)/(1000*3600*24)
        val diffHours = ((examDate.time-currDate.time)%(1000*3600*24))/(1000*3600)
        val diffMinutes = (((examDate.time-currDate.time)%(1000*3600*24))%(1000*3600))/(1000*60)
        var lessons:Array<Lesson>
        if (((diffDays==7L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==7L)&&(diffHours<=9L))||((diffDays==6L)&&(diffHours>=11L))||((diffDays==6L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            lessons=DataArrays.lessons[0]
        else if (((diffDays==6L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==6L)&&(diffHours<=9L))||((diffDays==5L)&&(diffHours>=11L))||((diffDays==5L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            lessons = DataArrays.lessons[1]
        else if (((diffDays==5L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==5L)&&(diffHours<=9L))||((diffDays==4L)&&(diffHours>=11L))||((diffDays==4L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            lessons=DataArrays.lessons[2]
        else if (((diffDays==4L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==4L)&&(diffHours<=9L))||((diffDays==3L)&&(diffHours>=11L))||((diffDays==3L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            lessons=DataArrays.lessons[3]
        else if (((diffDays==1L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==1L)&&(diffHours<=9L))||((diffDays==0L)&&(diffHours>=11L))||((diffDays==0L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            lessons=DataArrays.lessons[4]
        else lessons=arrayOf()
        adapterClasses2 = Classes2Adapter(lessons,onItemSkypeClickListener)
        binding?.classesList2?.adapter = adapterClasses2
    }
    override fun onDestroy() {
        adapterClasses2.onDestroy()
        binding=null
        super.onDestroy()
    }
}