package com.mustang4w.wang.kotlinpractiseproject.kotlin.expand

/**
 * 对运算符进行重载
 * a + b a.plus(b)
 * a - b a.minus(b)
 * a * b a.times(b)
 * a / b a.div(b)
 * a % b a.rem(b)
 * a++ a.inc()
 * a-- a.dec()
 * +a a.unaryPlus()
 * -a a.unaryMinus()
 * !a a.not()
 * a == b a.equals(b)
 * a > b a < b a >= b a <= b a.compareTo(b)
 * a..b a.rangeTo(b)
 * a[b] a.get(b)
 * a[b] = c a.set(b, c)
 * a in b b.contains(a)
 */
class Money(val value: Int) {

    /**
     * 重载+
     */
    operator fun plus(money: Money): Money {
        return Money(value + money.value)
    }

    /**
     * 多重重载+
     */
    operator fun plus(money: Int): Money {
        return Money(value + money)
    }

}

fun main() {
    val money1 = Money(10)
    val money2 = Money(15)
    val money3 = money1 + money2
    val money4 = money1 + 100
    val a = 10 + 10
    println(money3.value)
    println(money4.value)
}