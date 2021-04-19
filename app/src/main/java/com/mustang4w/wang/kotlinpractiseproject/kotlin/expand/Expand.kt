package com.mustang4w.wang.kotlinpractiseproject.kotlin.expand

/**
 * 扩展函数
 *
 * 格式：fun className.methodName(param1: Int, param2: Int): Int{}
 */
fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

operator fun String.times(time: Int): String {
    val builder = StringBuilder()
    repeat(time) {
        builder.append(this)
    }
    return builder.toString()
}

fun main() {
    val a = "hello1234..".lettersCount()
    println(a)
}