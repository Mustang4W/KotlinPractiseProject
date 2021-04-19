package com.mustang4w.wang.kotlinpractiseproject.kotlin.test

class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age),
    Study {

    init {
        println("sno is " + sno)
        println("grade is " + grade)
    }

    constructor(sno: String, grade: Int) : this(sno, grade, "", 0) {
        println("Second Constructor")
    }

    constructor() : this("", 1) {
        println("Second Constructor")
    }

    override fun readBooks() {
        println(name + "is reading books")
    }

    override fun doHomework() {
        println(name + "is doing homework")
    }

}