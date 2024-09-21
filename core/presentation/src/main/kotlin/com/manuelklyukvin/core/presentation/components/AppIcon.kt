package com.manuelklyukvin.core.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.manuelklyukvin.core.presentation.R
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    model: Painter,
    tint: Color? = null
) {
    Icon(
        modifier = modifier,
        painter = model,
        tint = tint ?: AppTheme.colorScheme.primary,
        contentDescription = null
    )
}

@Preview
@Composable
private fun AppIconPreview() {
    AppTheme {
        AppIcon(
            model = painterResource(R.drawable.logo),
            tint = AppTheme.colorScheme.primary
        )
    }
}