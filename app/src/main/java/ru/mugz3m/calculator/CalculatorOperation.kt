package ru.mugz3m.calculator

sealed class CalculatorOperation(val symbol: String) {
    object Sum : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Multiply : CalculatorOperation("×")
    object Divide : CalculatorOperation("÷")
}
