package ru.mugz3m.calculator.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbol: String,
    textColor: Color,
    alignment: Alignment,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = alignment,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
    ) {
        Text(
            text = symbol,
            fontSize = 32.sp,
            fontFamily = FontFamily.SansSerif,
            color = textColor
        )
    }
}
