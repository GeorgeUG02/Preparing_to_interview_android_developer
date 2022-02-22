package com.example.lesson4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson4.databinding.FragmentMainBinding
import java.util.*


class MainFragment : Fragment() {

    private var binding:FragmentMainBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainBinding.inflate(layoutInflater)
        return binding?.root
    }
    lateinit var adapterClasses1 : Classes1Adapter
    lateinit var adapterHomework : HomeworkAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val examDate = Date(122,2,1,10,0)
        val currDate = Date()
        val diffDays = (examDate.time-currDate.time)/(1000*3600*24)
        val diffHours = ((examDate.time-currDate.time)%(1000*3600*24))/(1000*3600)
        val diffMinutes = (((examDate.time-currDate.time)%(1000*3600*24))%(1000*3600))/(1000*60)
        binding?.exam?.text = binding?.exam?.text.toString() + "\n" + diffDays + " Дней " + diffHours + " Часов "+diffMinutes+" Минут "
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
        var homeworks:Array<Homework>
        if (((diffDays==8L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==8L)&&(diffHours<=9L))||((diffDays==7L)&&(diffHours>=11L))||((diffDays==7L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            homeworks=DataArrays.homeworks[0]
        else if (((diffDays==7L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==7L)&&(diffHours<=9L))||((diffDays==6L)&&(diffHours>=11L))||((diffDays==6L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            homeworks=DataArrays.homeworks[1]
        else if (((diffDays==6L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==6L)&&(diffHours<=9L))||((diffDays==5L)&&(diffHours>=11L))||((diffDays==5L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            homeworks=DataArrays.homeworks[2]
        else if (((diffDays==5L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==5L)&&(diffHours<=9L))||((diffDays==4L)&&(diffHours>=11L))||((diffDays==4L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            homeworks=DataArrays.homeworks[3]
        else if (((diffDays==4L) && (diffHours == 10L)&&(diffMinutes==0L))||((diffDays==4L)&&(diffHours<=9L))||(diffDays==3L)||(diffDays==2L)||((diffDays==1L)&&(diffHours>=11L))||((diffDays==1L)&&(diffHours==10L)&&(diffMinutes>=1L)))
            homeworks=DataArrays.homeworks[4]
        else homeworks=arrayOf()
        adapterClasses1 = Classes1Adapter(lessons)
        binding?.classesList1?.adapter = adapterClasses1
        adapterHomework = HomeworkAdapter(homeworks)
        binding?.homeworkList?.adapter = adapterHomework
    }

    override fun onDestroy() {
        adapterClasses1.onDestroy()
        adapterHomework.onDestroy()
        binding = null
        super.onDestroy()
    }
}