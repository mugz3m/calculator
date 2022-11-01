package ru.mugz3m.calculator.test

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.WithJunitRule
import org.junit.Rule
import ru.mugz3m.calculator.MainActivity

@WithJunitRule
class CalculatorSteps {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Given("a clear input field")
    fun clearInputField() {
        composeRule.onNodeWithText("AC").assertIsDisplayed()
        composeRule.onNodeWithText("AC").performClick()
        composeRule.onNodeWithContentDescription("InputField").assertTextContains("")
    }

    @When("click {string} button")
    fun clickNumberButtonWhen(value: String) {
        composeRule.onNodeWithText(value).performClick()
    }

    @And("click plus button")
    fun clickPlusButton() {
        composeRule.onNodeWithText("+").performClick()
    }

    @And("click minus button")
    fun clickMinusButton() {
        composeRule.onNodeWithText("-").performClick()
    }

    @And("click multiply button")
    fun clickMultiplyButton() {
        composeRule.onNodeWithText("×").performClick()
    }

    @And("click divide button")
    fun clickDivideButton() {
        composeRule.onNodeWithText("÷").performClick()
    }

    @And("click decimal button")
    fun clickDecimalButton() {
        composeRule.onNodeWithText(".").performClick()
    }

    @And("click lead to negative button")
    fun clickLeadToNegativeButton() {
        composeRule.onNodeWithText("±").performClick()
    }

    @And("click equal button")
    fun clickEqualButton() {
        composeRule.onNodeWithText("=").performClick()
    }

    @And("click delete button")
    fun clickDeleteButton() {
        composeRule.onNodeWithText("Del").performClick()
    }

    @And("click clear button")
    fun clickClearButton() {
        composeRule.onNodeWithText("AC").performClick()
    }

    @Then("{string} is displayed in input field")
    fun checkInputField(value: String) {
        composeRule.onNodeWithContentDescription("InputField").assertTextContains(value)
    }
}
