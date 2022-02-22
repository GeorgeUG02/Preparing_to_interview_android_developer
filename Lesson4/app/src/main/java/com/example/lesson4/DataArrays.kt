package com.example.lesson4

object DataArrays {
    val lessons:Array<Array<Lesson>> = arrayOf(
        arrayOf(Lesson("Algebra","8:00-8:45",false),Lesson("History","9:00-9.45",false),Lesson("Physical Education","10:00-11:35",true),Lesson("Biology","11:45-12:30",false)),
        arrayOf(Lesson("Physics","8:00-8:45",false),Lesson("Drawing","9:00-9.45",true),Lesson("Informatics","10:00-10:45",false),Lesson("Literature","10:50-12:30",true)),
        arrayOf(Lesson("Physical Education","8:00-9:35",true),Lesson("Chemistry","10:00-10:45",false),Lesson("Geometry","10:50-11:35",false)),
        arrayOf(Lesson("Astronomy","8:00-8:45",true),Lesson("Physics","9:00-9:45",false),Lesson("Economics","10:00-10:45",false),Lesson("Geographics","10:50-11:35",false),Lesson("Algebra","11:45-12:30",false)),
        arrayOf(Lesson("Geometry","8:00-8:45",false),Lesson("Literature","9:00-9:45",false),Lesson("History","10:00-11:35",true),Lesson("Physics","11:45-12:30",false),Lesson("Algebra","12:45-13:30",false))
        )
    val homeworks:Array<Array<Homework>> = arrayOf(
        arrayOf(Homework("Physics","Прочитать пар. 12 ,выполнить упр. 3,5"),Homework("Informatics","Прочитать пар. 15, выполнить упр. 7"),Homework("Geometry","Прочитать пар. 14, выполнить упр. 9,10"),Homework("Chemistry","Прочитать пар. 17, выполнить упр. 1-3"),Homework("Algebra","Прочитать пар.15 выполнить упр. 3-7"),Homework("Biology","Прочитать пар. 13-15 , выполнить упр. 2-5"),Homework("History","Прочитать пар. 17"),Homework("Geographics","Прочитать пар.16")),
        arrayOf(Homework("Physics","Прочитать пар. 12 ,выполнить упр. 3,5"),Homework("Informatics","Прочитать пар. 15, выполнить упр. 7"),Homework("Geometry","Прочитать пар. 14, выполнить упр. 9,10"),Homework("Chemistry","Прочитать пар. 17, выполнить упр. 1-3"),Homework("Algebra","Прочитать пар.16 выполнить упр. 2,4,6,9"),Homework("Geographics","Прочитать пар.16")),
        arrayOf(Homework("Physics","Прочитать пар. 13 ,выполнить упр. 4"),Homework("Geometry","Прочитать пар. 14, выполнить упр. 9,10"),Homework("Chemistry","Прочитать пар. 17, выполнить упр. 1-3"),Homework("Algebra","Прочитать пар.16 выполнить упр. 2,4,6,9"),Homework("Geographics","Прочитать пар.16")),
        arrayOf(Homework("Physics","Прочитать пар. 13 ,выполнить упр. 4"),Homework("Geometry","Прочитать пар. 15, выполнить упр. 6"),Homework("Algebra","Прочитать пар.16 выполнить упр. 2,4,6,9"),Homework("Geographics","Прочитать пар.16")),
        arrayOf(Homework("Physics","Прочитать пар. 14 ,выполнить упр. 3"),Homework("Geometry","Прочитать пар. 15, выполнить упр. 6"),Homework("Algebra","Прочитать пар.17 выполнить упр. 5,8")),
        )
}