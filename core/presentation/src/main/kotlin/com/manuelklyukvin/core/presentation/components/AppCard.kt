package com.manuelklyukvin.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    isDefaultPaddingEnabled: Boolean = false,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .background(
                color = AppTheme.colorScheme.surface,
                shape = AppTheme.shapes.roundedCornerShape
            )
            .then(
                if (isDefaultPaddingEnabled) {
                    Modifier.padding(AppTheme.shapes.paddingMedium)
                } else {
                    Modifier
                }
            ),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}

@Preview
@Composable
private fun LightAppCardPreview() {
    AppCardPreview(isDarkThemeEnabled = false)
}

@Preview
@Composable
private fun DarkAppCardPreview() {
    AppCardPreview(isDarkThemeEnabled = true)
}

@Composable
private fun AppCardPreview(isDarkThemeEnabled: Boolean) {
    AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
        AppCard(isDefaultPaddingEnabled = true) {
            Text(
                text = "Preview",
                style = AppTheme.typography.body,
                color = AppTheme.colorScheme.onSurface
            )
        }
    }
}