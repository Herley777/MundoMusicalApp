package com.example.mundomusical.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MundoMusicalColors = darkColorScheme(
    primary = Color(0xFFFFC857),
    onPrimary = Color(0xFF2A2100),
    secondary = Color(0xFFB8C4FF),
    tertiary = Color(0xFFE7A8FF),
    background = Color(0xFF101018),
    surface = Color(0xFF191922),
    surfaceVariant = Color(0xFF292936)
)

@Composable
fun MundoMusicalTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MundoMusicalColors,
        typography = Typography(),
        content = content
    )
}
