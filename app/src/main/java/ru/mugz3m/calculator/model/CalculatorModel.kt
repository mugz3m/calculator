package ru.mugz3m.calculator.model

class CalculatorModel : ICalculator {
    override fun sum(a: Double, b: Double): Double = a + b

    override fun subtract(a: Double, b: Double): Double = a - b

    override fun multiply(a: Double, b: Double): Double = a * b

    override fun divide(a: Double, b: Double): Double {
        if (b == 0.0) throw ArithmeticException()
        return a / b
    }
}
