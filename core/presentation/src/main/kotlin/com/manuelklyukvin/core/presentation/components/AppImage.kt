package com.manuelklyukvin.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.manuelklyukvin.core.presentation.R
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    model: Any,
    contentScale: ContentScale = ContentScale.Fit
) {
    if (model is Painter) {
        Image(
            modifier = modifier,
            painter = model,
            contentScale = contentScale,
            contentDescription = null
        )
    } else {
        AsyncImage(
            modifier = modifier,
            model = model,
            contentScale = contentScale,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun AppImagePreview() {
    AppTheme {
        AppImage(model = painterResource(R.drawable.logo))
    }
}