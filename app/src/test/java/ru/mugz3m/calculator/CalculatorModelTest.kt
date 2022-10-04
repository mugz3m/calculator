package ru.mugz3m.calculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import ru.mugz3m.calculator.model.CalculatorModel

internal class CalculatorModelTest {

    private val testCalculatorModel: CalculatorModel = CalculatorModel()

    @Test
    fun sum() {
        val expected = -19.8
        assertEquals(expected, testCalculatorModel.sum(-10.0, -9.8), 0.0)
    }

    @Test
    fun subtract() {
        val expected = 109.25
        assertEquals(expected, testCalculatorModel.subtract(99.75, -9.5), 0.0)
    }

    @Test
    fun multiply() {
        val expected = 152.1
        assertEquals(expected, testCalculatorModel.multiply(39.0, 3.9), 0.0)
    }

    @Test
    fun divide() {
        val expected = 16.2
        assertEquals(expected, testCalculatorModel.divide(40.5, 2.5), 0.0)
    }

    @Test
    fun divideByZero() {
        val expected = Double.POSITIVE_INFINITY
        assertEquals(expected, testCalculatorModel.divide(40.5, 0.0), 0.0)
    }
}
