package com.mustang4w.wang.kotlinpractiseproject.kotlin.test

fun main() {

    withMethod()
    runMethod()
    applyMethod()

}

fun withMethod() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    //with函数接收两个参数：第一个参数可以是一个任意类型的对象，第二个参数是一个Lambda表达式。
    //with函数会在Lambda表达式中提供第一个参数对象的上下文，并使用Lambda表达 式中的最后一行代码作为返回值返回
    val result = with(StringBuilder()) {
        append("Start\n")
        for (fruit in list) {
            append("$fruit\n")
        }
        append("End")
        toString()
    }
    println(result)
}

fun runMethod() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    //run函数通常不会直接调用，而是要在某个对象的基础上调用
    //run函数只接收一个Lambda参数，并且会在Lambda表达式中提供调用对象的上下文。
    val result = StringBuilder().run {
        append("Start\n")
        for (fruit in list) {
            append("$fruit\n")
        }
        append("End")
        toString()
    }
    println(result)
}


fun applyMethod() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    //apply函数无法指定返回值，而是会自动返回调用对象本身，其余和run方法类似
    val result = StringBuilder().apply {
        append("Start\n")
        for (fruit in list) {
            append("$fruit\n")
        }
        append("End")
    }
    println(result.toString())
}