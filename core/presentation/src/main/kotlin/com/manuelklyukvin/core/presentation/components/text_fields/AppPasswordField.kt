package com.manuelklyukvin.core.presentation.components.text_fields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manuelklyukvin.core.presentation.R
import com.manuelklyukvin.core.presentation.components.AppIcon
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
fun AppPasswordField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    label: String? = null,
    hint: String? = null,
    error: String? = null
) {
    CoreTextField(
        modifier = modifier,
        state = state,
        label = label,
        innerTextField = {
            InnerTextField(
                state = state,
                hint = hint,
                error = error
            )
        },
        error = error
    )
}

@Composable
private fun InnerTextField(
    state: TextFieldState,
    hint: String?,
    error: String?
) {
    var isContentVisible by remember {
        mutableStateOf(false)
    }

    val textObfuscationMode: TextObfuscationMode
    val showPasswordButtonTint: Color

    if (isContentVisible) {
        textObfuscationMode = TextObfuscationMode.Visible
        showPasswordButtonTint = AppTheme.colorScheme.primary
    } else {
        textObfuscationMode = TextObfuscationMode.RevealLastTyped
        showPasswordButtonTint = AppTheme.colorScheme.onSurface
    }

    BasicSecureTextField(
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textObfuscationMode = textObfuscationMode,
        cursorBrush = SolidColor(AppTheme.colorScheme.primary),
        decorator = { inputField ->
            Decorator(
                state = state,
                inputField = inputField,
                hint = hint,
                showPasswordButtonTint = showPasswordButtonTint,
                onShowPasswordButtonClicked = {
                    isContentVisible = !isContentVisible
                }
            )
        }
    )
}

@Composable
private fun Decorator(
    state: TextFieldState,
    inputField: @Composable () -> Unit,
    hint: String?,
    showPasswordButtonTint: Color,
    onShowPasswordButtonClicked: () -> Unit
) {
    Row {
        Box(modifier = Modifier.weight(1f)) {
            inputField()
            if (state.text.isEmpty() && hint != null) {
                Text(
                    text = hint,
                    style = AppTheme.typography.body,
                    color = AppTheme.colorScheme.outline
                )
            }
        }
        IconButton(
            modifier = Modifier
                .padding(start = AppTheme.shapes.paddingMedium)
                .size(AppTheme.shapes.sizeExtraSmall),
            onClick = onShowPasswordButtonClicked
        ) {
            AppIcon(
                modifier = Modifier.fillMaxSize(),
                model = painterResource(id = R.drawable.eye),
                tint = showPasswordButtonTint
            )
        }
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
            AppPasswordField(state = TextFieldState("Preview"))
            AppPasswordField(
                state = TextFieldState("Preview"),
                label = "Preview"
            )
            AppPasswordField(
                state = TextFieldState(),
                hint = "Preview"
            )
            AppPasswordField(
                state = TextFieldState(),
                error = "Preview"
            )
        }
    }
}