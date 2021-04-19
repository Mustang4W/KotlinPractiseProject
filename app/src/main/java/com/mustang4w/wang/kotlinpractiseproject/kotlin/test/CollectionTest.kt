package com.mustang4w.wang.kotlinpractiseproject.kotlin.test

import android.annotation.SuppressLint
import kotlin.collections.HashMap

@SuppressLint("DefaultLocale")
fun main() {

    //listOf创建的不可变集合
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    for (fruit in list) {
        println(fruit)
    }

    //mutableListOf创建的可变集合
    val mutableList = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
    mutableList.add("Watermelon")
    for (fruit in mutableList) {
        println(fruit)
    }

    //lambda
    val maxlength = mutableList.maxBy { it.length }
    //
    val newLowerList = mutableList.map { it.toLowerCase() }
    for (fruit in newLowerList) {
        println(fruit)
    }
    val newFilterList = mutableList.filter { it.length <= 5 }.map { it.toUpperCase() }
    for (fruit in newFilterList) {
        println(fruit)
    }
    //有一个或以上长度大于等于5
    val isAny = mutableList.any { it.length >= 5 }
    //全部长度都大于等于5
    val isAll = mutableList.all { it.length >= 5 }


    //Set集合方法同List
    val set = setOf("aaa", "bbb", "ccc")
    val mutableSet = mutableSetOf("aaa", "bbb", "ccc")


    val map = HashMap<String, Int>()
    map["Apple"] = 1
    map["Banana"] = 2
    map["Orange"] = 3
    map["Pear"] = 4
    map["Grape"] = 5
    val index = map["Apple"]
    val map2 = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3)
    for ((fruit, number) in map) {
        println("Fruit is " + fruit + ", and Number is " + number)
    }

    Thread(Runnable {
        println("Thread is started")
    }).start()

    Thread {
        println("Thread is started")
    }.start()
}