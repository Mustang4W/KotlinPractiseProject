package com.mustang4w.wang.kotlinpractiseproject.kotlin.hof

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

/**
 * 内联函数
 */
inline fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

inline fun inlineTest(block1: () -> Unit, noinline block2: () -> Unit) {
    block1()
    block2()
}

fun printString(str: String, block: (String) -> Unit) {
    println("printString start")
    block(str)
    println("printString end")
}

fun testReturn() {
    printString("") { s ->
        if (s.isEmpty()) {
            return@printString
        }
    }
    println("testReturn Done")
}

/**
 * 使用了crossinline就无法使用return关键字进行返回
 *
 * 但是可以使用return@runRunnable进行局部返回
 */
inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}

fun main() {
    val num1 = 100
    val num2 = 80
    val result1 = num1AndNum2(num1, num2, ::plus)
    val result2 = num1AndNum2(num1, num2, ::minus)
    println("result1 is $result1")
    println("result2 is $result2")

    val result3 = num1AndNum2(num1, num2) { n1, n2 -> n1 * n2 }
    val result4 = num1AndNum2(num1, num2) { n1, n2 -> n1 / n2 }
    println("result3 is $result3")
    println("result4 is $result4")

    val list = listOf("apple", "banana", "orange", "pear", "grape")
    val resultSb = StringBuilder().build {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits")
    }
    println(resultSb.toString())

    inlineTest({
        println("block1")
    }, {
        println("block2")
    })

    testReturn()

    runRunnable {
        println("runnable")
    }
}

class hof {

    fun example(func: (String, Int) -> Unit) {
        func("hello", 123)
    }

}
