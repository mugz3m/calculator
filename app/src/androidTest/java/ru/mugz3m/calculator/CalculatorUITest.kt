package ru.mugz3m.calculator

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun inputFieldInitiallyEmpty() {
        composeTestRule.onNodeWithContentDescription("InputField").assertExists()
    }

    @Test
    fun clickNumber0Button() {
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("0")
    }

    @Test
    fun doubleClickNumberAfter0Button() {
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("2").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("0")
    }

    @Test
    fun clickNumber1Button() {
        composeTestRule.onNodeWithText("1").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("1")
    }

    @Test
    fun clickNumber2Button() {
        composeTestRule.onNodeWithText("2").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("2")
    }

    @Test
    fun clickNumber3Button() {
        composeTestRule.onNodeWithText("3").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("3")
    }

    @Test
    fun clickNumber4Button() {
        composeTestRule.onNodeWithText("4").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("4")
    }

    @Test
    fun clickNumber5Button() {
        composeTestRule.onNodeWithText("5").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("5")
    }

    @Test
    fun clickNumber6Button() {
        composeTestRule.onNodeWithText("6").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("6")
    }

    @Test
    fun clickNumber7Button() {
        composeTestRule.onNodeWithText("7").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("7")
    }

    @Test
    fun clickNumber8Button() {
        composeTestRule.onNodeWithText("8").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("8")
    }

    @Test
    fun clickNumber9Button() {
        composeTestRule.onNodeWithText("9").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("9")
    }

    @Test
    fun clickSumButtonFirst() {
        composeTestRule.onNodeWithText("+").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("")
    }

    @Test
    fun clickSubtractButtonFirst() {
        composeTestRule.onNodeWithText("-").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("")
    }

    @Test
    fun clickMultiplyButtonFirst() {
        composeTestRule.onNodeWithText("×").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("")
    }

    @Test
    fun clickDivideButtonFirst() {
        composeTestRule.onNodeWithText("÷").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("")
    }

    @Test
    fun clickDecimalButtonFirst() {
        composeTestRule.onNodeWithText(".").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("")
    }

    @Test
    fun clickClearButton() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("AC").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("")
    }

    @Test
    fun clickLeadToNegativeButton() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("±").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("-91")
    }

    @Test
    fun clickDeleteButton() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("±").performClick()
        composeTestRule.onNodeWithText("Del").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("-9")
    }

    @Test
    fun testSum() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("±").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("78.7")
    }

    @Test
    fun testSubtract() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("6").performClick()
        composeTestRule.onNodeWithText("±").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("103.8")
    }

    @Test
    fun testMultiply() {
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("×").performClick()
        composeTestRule.onNodeWithText("6").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("78.125")
    }

    @Test
    fun testDivide() {
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("3").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("÷").performClick()
        composeTestRule.onNodeWithText("6").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("±").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("-2.16")
    }

    @Test
    fun testDivideByZero() {
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("3").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("÷").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("Infinity")
    }

    @Test
    fun testDoublePerformLeadToNegative() {
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("±").performClick()
        composeTestRule.onNodeWithText("3").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("±").performClick()
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        composeTestRule.onNodeWithContentDescription("InputField").assertTextContains("14.5")
    }
}
