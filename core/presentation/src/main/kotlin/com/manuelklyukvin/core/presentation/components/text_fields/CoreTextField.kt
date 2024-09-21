package com.manuelklyukvin.core.presentation.components.text_fields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.delete
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
internal fun CoreTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    label: String? = null,
    innerTextField: @Composable () -> Unit,
    error: String? = null,
    maxLength: Int? = null
) {
    val valueLength = state.text.length

    if (maxLength != null) {
        LaunchedEffect(valueLength) {
            if (valueLength > maxLength) {
                state.edit {
                    delete(maxLength, valueLength)
                }
            }
        }
    }

    Column(modifier = modifier) {
        if (label != null) {
            Text(
                text = label,
                style = AppTheme.typography.label,
                color = AppTheme.colorScheme.outline
            )
        }
        innerTextField()
        if (error != null) {
            Text(
                text = error,
                style = AppTheme.typography.label,
                color = AppTheme.colorScheme.error
            )
        }
    }
}