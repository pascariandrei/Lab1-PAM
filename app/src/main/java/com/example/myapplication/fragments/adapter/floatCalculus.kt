package com.example.myapplication.fragments.adapter

fun main() {
    var X = "0101001"
    var Y = "1100010"
    var eX = -29
    var eY = 27

    println("Mx = $X")
    println("My = $Y")

    fun type(num: String): String {
        if (num.take(1) == "0") {
            return num
        }else return "0"
    }

}




