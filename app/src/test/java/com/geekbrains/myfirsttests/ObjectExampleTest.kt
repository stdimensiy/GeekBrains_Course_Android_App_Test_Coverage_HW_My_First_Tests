package com.geekbrains.myfirsttests

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ObjectExampleTest {
    @Test
    @DisplayName("A() == B()")
    fun assertSame_SimpleTest() {
        val a = ObjectExample()
        val b = a
        Assertions.assertSame(a, b, "a() it is b()")
    }

    @Test
    @DisplayName("A() <> B()")
    fun assertNotSame_SimpleTest() {
        val a = ObjectExample()
        val b = ObjectExample()
        Assertions.assertNotSame(a, b, "a() it is not b()")
    }
}