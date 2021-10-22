package com.geekbrains.myfirsttests

class Calculator {
    /*
    Сложение целых чисел
     */
    fun add(a: Int, b: Int): Int {
        println("Выполняется сложение $a и $b")
        return a + b
    }

    /*
    Вычитание целых чисел
     */
    fun subtract(a: Int, b: Int): Int {
        println("Выполняется вычитание $a и $b")
        return a - b
    }

    /*
    Умножение целых чисел
     */
    fun multiply(a: Int, b: Int): Int {
        println("Выполняется умножение $a и $b")
        return a * b
    }

    /*
    Умножение деление чисел
     */
    fun divide(a: Int, b: Int): Int {
        println("Выполняется деление $a и $b")
        return a / b
    }

}
