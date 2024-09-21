package com.manuelklyukvin.core.presentation.components.text_fields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    label: String? = null,
    hint: String? = null,
    error: String? = null,
    singleLine: Boolean = true,
    maxLength: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val lineLimits = if (singleLine) {
        TextFieldLineLimits.SingleLine
    } else {
        TextFieldLineLimits.Default
    }

    CoreTextField(
        modifier = modifier,
        state = state,
        label = label,
        innerTextField = {
            InnerTextField(
                state = state,
                hint = hint,
                error = error,
                lineLimits = lineLimits,
                keyboardType = keyboardType
            )
        },
        error = error,
        maxLength = maxLength
    )
}

@Composable
private fun InnerTextField(
    state: TextFieldState,
    hint: String?,
    error: String?,
    lineLimits: TextFieldLineLimits,
    keyboardType: KeyboardType
) {
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = AppTheme.colorScheme.surface,
                shape = AppTheme.shapes.roundedCornerShape
            )
            .then(
                if (error != null) {
                    Modifier.border(
                        width = 1.dp,
                        color = AppTheme.colorScheme.error,
                        shape = AppTheme.shapes.roundedCornerShape
                    )
                } else {
                    Modifier
                }
            )
            .padding(AppTheme.shapes.paddingMedium),
        state = state,
        textStyle = AppTheme.typography.body.copy(
            color = AppTheme.colorScheme.onSurface
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        lineLimits = lineLimits,
        cursorBrush = SolidColor(AppTheme.colorScheme.primary),
        decorator = { inputField ->
            Decorator(
                state = state,
                inputField = inputField,
                hint = hint
            )
        }
    )
}

@Composable
private fun Decorator(
    state: TextFieldState,
    inputField: @Composable () -> Unit,
    hint: String?
) {
    inputField()
    if (state.text.isEmpty() && hint != null) {
        Text(
            text = hint,
            style = AppTheme.typography.body,
            color = AppTheme.colorScheme.outline
        )
    }
}

@Preview
@Composable
private fun LightAppTextFieldPreview() {
    AppTextFieldPreview(isDarkThemeEnabled = false)
}

@Preview
@Composable
private fun DarkAppTextFieldPreview() {
    AppTextFieldPreview(isDarkThemeEnabled = true)
}

@Composable
private fun AppTextFieldPreview(isDarkThemeEnabled: Boolean) {
    AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            AppTextField(state = TextFieldState("Preview"))
            AppTextField(
                state = TextFieldState("Preview"),
                label = "Preview"
            )
            AppTextField(
                state = TextFieldState(),
                hint = "Preview"
            )
            AppTextField(
                state = TextFieldState(),
                error = "Preview"
            )
        }
    }
}