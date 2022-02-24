package com.example.lesson5

data class Posts(
    val data:Data
)
data class Data(
    val children:Array<Data2>
)
data class Data2(
    val data:Data3
)
data class Data3(
    val permalink:String
)