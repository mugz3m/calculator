package ru.mugz3m.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ru.mugz3m.calculator.model.CalculatorModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    private val model: CalculatorModel by lazy { CalculatorModel() }

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> performClear()
            is CalculatorAction.Delete -> performDelete()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.LeadToNegative -> performLeadToNegative()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.firstNumber.length >= MAX_NUM_LENGTH || state.firstNumber == "0") {
                return
            }
            state = state.copy(
                firstNumber = state.firstNumber + number
            )
            return
        }
        if (state.secondNumber.length >= MAX_NUM_LENGTH || state.secondNumber == "0") {
            return
        }
        state = state.copy(
            secondNumber = state.secondNumber + number
        )
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.firstNumber.contains(".")
            && state.firstNumber.isNotBlank()
        ) {
            state = state.copy(
                firstNumber = state.firstNumber + "."
            )
            return
        }

        if (!state.secondNumber.contains(".") && state.secondNumber.isNotBlank()
        ) {
            state = state.copy(
                secondNumber = state.secondNumber + "."
            )
        }
    }

    private fun performClear() {
        state = CalculatorState()
    }

    private fun performDelete() {
        when {
            state.secondNumber.isNotBlank() -> state = state.copy(
                secondNumber = state.secondNumber.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.firstNumber.isNotBlank() -> state = state.copy(
                firstNumber = state.firstNumber.dropLast(1)
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.firstNumber.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun performCalculation() {
        val firstNumber = state.firstNumber.toDoubleOrNull()
        val secondNumber = state.secondNumber.toDoubleOrNull()
        if (firstNumber != null && secondNumber != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Sum -> model.sum(firstNumber, secondNumber)
                is CalculatorOperation.Subtract -> model.subtract(firstNumber, secondNumber)
                is CalculatorOperation.Multiply -> model.multiply(firstNumber, secondNumber)
                is CalculatorOperation.Divide -> model.divide(firstNumber, secondNumber)
                null -> return
            }
            state = state.copy(
                firstNumber = result.toString().take(15),
                secondNumber = "",
                operation = null,
            )
        }
    }

    private fun performLeadToNegative() {
        state = if (state.operation == null) {
            state.copy(
                firstNumber = "-" + state.firstNumber
            )
        } else {
            state.copy(
                secondNumber = "-" + state.secondNumber
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}
