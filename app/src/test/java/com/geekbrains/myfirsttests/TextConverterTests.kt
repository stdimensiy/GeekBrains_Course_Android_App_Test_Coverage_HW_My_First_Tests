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

    @Test
    @DisplayName("String to Int ARRAY: 11 222 3333 = {11, 222, 3333}")
    fun stringToIntArray_SimpleTest() {
        val textConverter = TextConverter()
        Assertions.assertArrayEquals(arrayOf(11, 222, 3333),
            textConverter.stringToIntArray("11 222 3333"),
            "should equal NULL")
    }


    @DisplayName("String to Int ARRAY - ParameterizedTest")
    @ParameterizedTest(name = "{0} = '{'{1}'}'")
    @CsvSource(
        "1 22 333, 1; 22; 333",
        "4 11 152 51, 4; 11; 152; 51",
        "-21 10 -333, -21; 10; -333",
        "7 6 5 4 3 2 1, 7; 6; 5; 4; 3; 2; 1",
    )
    fun stringToIntArray_ParamterizedTest(
        str: String,
        rawExpectedResult: String,
    ) {
        val textConverter = TextConverter()
        val expectedResult = rawExpectedResult.split("; ").map { it.toInt() }.toTypedArray()
        Assertions.assertArrayEquals(
            expectedResult, textConverter.stringToIntArray(str)
        ) { "$str should equal ${expectedResult.toString()}" }
    }
}