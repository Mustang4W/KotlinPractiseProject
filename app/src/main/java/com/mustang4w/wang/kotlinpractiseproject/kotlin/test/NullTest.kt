package com.mustang4w.wang.kotlinpractiseproject.kotlin.test


var global: String? = "HELLO WORLD"
var study: Study? = null

fun main() {

    val str: String? = null
    doSomething(str)

    global = toLowerCaseFun()
    println("Global = $global")

    doStudy()
    printString(10, "Hello")
    printString(100)
    printString(str = "handsome")
}

fun doSomething(str: String?) {
    println(str)
    println(str?.length ?: 0)
    println(str ?: "is Null")
}

fun toLowerCaseFun(): String {
    return global!!.toLowerCase()
}

fun doStudy() {
    study?.let {
        it.doHomework()
        it.readBooks()
    }
}

fun printString(num: Int = 1, str: String = "World") {
    println("The number is $num and the string is $str")
}
