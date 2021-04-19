package com.mustang4w.wang.kotlinpractiseproject.kotlin.test

fun main() {

    val a = 0..10
    val range = 0 until 10
    val range2 = 10 downTo 1

    for (i in range2/* step 2*/) {
        println(i)
    }

    val person = Person("XiongQiang", 16)
    person.eat()


    val student = Student("XQ", 3, "Xiongqiang2Hao", 18)
    val student2 = Student()
    val student3 = Student("XXQQ", 1)

    doStudy(student)

}

fun doStudy(study: Study) {
    study.readBooks()
    study.doHomework()
}
