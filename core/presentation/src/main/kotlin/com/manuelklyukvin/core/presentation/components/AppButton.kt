package com.manuelklyukvin.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String? = null,
    isEnabled: Boolean = true,
    containerColor: Color = AppTheme.colorScheme.primary,
    contentColor: Color = AppTheme.colorScheme.onPrimary,
    content: @Composable (() -> Unit)? = null
) {
    val alpha = 0.7f
    val disabledContainerColor = containerColor.copy(alpha = alpha)
    val disabledContentColor = contentColor.copy(alpha = alpha)

    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled,
        shape = AppTheme.shapes.roundedCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        ),
        contentPadding = PaddingValues(
            vertical = AppTheme.shapes.paddingSmall,
            horizontal = AppTheme.shapes.paddingLarge
        )
    ) {
        if (text != null) {
            Text(
                text = text,
                style = AppTheme.typography.body,
                color = if (isEnabled) {
                    contentColor
                } else {
                    disabledContentColor
                }
            )
        } else if (content != null) {
            content()
        }
    }
}

@Preview
@Composable
private fun LightPrimaryAppButtonPreview() {
    PrimaryAppButtonPreview(isDarkThemeEnabled = false)
}

@Preview
@Composable
private fun LightSecondaryAppButtonPreview() {
    SecondaryAppButtonPreview(isDarkThemeEnabled = false)
}

@Preview
@Composable
private fun DarkPrimaryAppButtonPreview() {
    PrimaryAppButtonPreview(isDarkThemeEnabled = true)
}

@Preview
@Composable
private fun DarkSecondaryAppButtonPreview() {
    SecondaryAppButtonPreview(isDarkThemeEnabled = true)
}

@Composable
private fun PrimaryAppButtonPreview(isDarkThemeEnabled: Boolean) {
    AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
        Column {
            AppButton(
                text = "Preview",
                onClick = {  }
            )
            AppButton(
                text = "Preview",
                onClick = {  },
                isEnabled = false
            )
        }
    }
}

@Composable
private fun SecondaryAppButtonPreview(isDarkThemeEnabled: Boolean) {
    AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
        Column {
            AppButton(
                text = "Preview",
                onClick = {  },
                containerColor = AppTheme.colorScheme.secondary,
                contentColor = AppTheme.colorScheme.onSecondary
            )
            AppButton(
                text = "Preview",
                onClick = {  },
                isEnabled = false,
                containerColor = AppTheme.colorScheme.secondary,
                contentColor = AppTheme.colorScheme.onSecondary
            )
        }
    }
}