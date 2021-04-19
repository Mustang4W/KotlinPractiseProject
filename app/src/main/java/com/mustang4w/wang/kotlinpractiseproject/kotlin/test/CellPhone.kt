package com.mustang4w.wang.kotlinpractiseproject.kotlin.test

data class CellPhone(val brand: String, val price: Double)

fun main() {

    val cellPhone1 = CellPhone("Xiaomi", 233.4)
    val cellPhone2 = CellPhone("Xiaomi", 233.2)

    println(cellPhone1)
    println("cellPhone1 is equals cellPhone2? " + cellPhone1.equals(cellPhone2))


}