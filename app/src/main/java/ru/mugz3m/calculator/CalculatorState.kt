package ru.mugz3m.calculator

data class CalculatorState(
    val firstNumber: String = "",
    val operation: CalculatorOperation? = null,
    val secondNumber: String = ""
)
