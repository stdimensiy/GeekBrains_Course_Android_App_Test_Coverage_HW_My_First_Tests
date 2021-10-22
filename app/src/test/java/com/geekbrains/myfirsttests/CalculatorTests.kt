package com.geekbrains.myfirsttests

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTests {
    @Test
    @DisplayName("Correct Addition Two Numbers: 2 + 8 = 10")
    fun calculator_CorrectAdditionTwoNumbers() {
        val calculator = Calculator()
        Assertions.assertEquals(10, calculator.add(2, 8), "2 + 8 should equal 10")
    }

    @Test
    @DisplayName("Correct Subtraction Two Numbers: 8 - 2 = 6")
    fun calculator_CorrectSubtractionTwoNumbers() {
        val calculator = Calculator()
        Assertions.assertEquals(6, calculator.subtract(8, 2), "8 - 2 should equal 6")
    }

    @Test
    @DisplayName("Correct Multiplication Two Numbers: 8 * 2 = 16")
    fun calculator_CorrectMultiplicationTwoNumbers() {
        val calculator = Calculator()
        Assertions.assertEquals(16, calculator.multiply(8, 2), "8 * 2 should equal 16")
    }

    @Test
    @DisplayName("Correct Division Two Numbers: 8 / 2 = 4")
    fun calculator_CorrectDivisionTwoNumbers() {
        val calculator = Calculator()
        Assertions.assertEquals(4, calculator.divide(8, 2), "8 / 2 should equal 4")
    }
}