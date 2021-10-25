package com.geekbrains.myfirsttests

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TextConverterTests {
    @Test
    @DisplayName("Combining first and last names: John + Doe = John Doe")
    fun nameConnector_SimpleTest() {
        val textConverter = TextConverter()
        Assertions.assertEquals("John Doe",
            textConverter.nameConnector("John", "Doe"),
            "should equal John Doe")
    }

    //Параметрический тест с набором допустимых значений


    @DisplayName("Combining first and last names")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
        "John,   Doe,    John Doe",
        "Vasya,  Pupkin,  Vasya Pupkin",
    )
    fun nameConnector_ParameterizedTest(
        firstName: String,
        lastName: String,
        expectedResult: String,
    ) {
        val textConverter = TextConverter()
        Assertions.assertEquals(
            expectedResult, textConverter.nameConnector(firstName = firstName, lastName = lastName)
        ) { "$firstName + $lastName should equal $expectedResult" }
    }

    @Test
    @DisplayName("String to Long: 123456 = 123456(Long) NOTNULL")
    fun stringToLong_SimpleTest() {
        val textConverter = TextConverter()
        Assertions.assertEquals(123456,
            textConverter.stringToLong("123456"),
            "should equal 123456 (Long)")
        Assertions.assertNotNull(textConverter.stringToLong("123456"),
            "should equal NOT NULL")
    }

    @Test
    @DisplayName("String to Long: 123456.7 = NULL")
    fun stringToLong_SimpleTest_IncorrectValue() {
        val textConverter = TextConverter()
        Assertions.assertNull(textConverter.stringToLong("123456.7"),
            "should equal NULL")
    }
}