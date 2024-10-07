package com.manuelklyukvin.feed.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.manuelklyukvin.core.presentation.components.AppButton
import com.manuelklyukvin.core.presentation.theme.AppTheme
import com.manuelklyukvin.feed.presentation.R
import com.manuelklyukvin.feed.presentation.screen.models.FeedEvent

@Composable
fun ErrorFeedScreen(error: String?, onEvent: (FeedEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.paddingSmall),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error ?: stringResource(R.string.feed_default_error),
            style = AppTheme.typography.body,
            color = AppTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(AppTheme.shapes.paddingExtraSmall))
        AppButton(
            text = stringResource(R.string.feed_retry_button),
            onClick = {
                onEvent(FeedEvent.OnRetryButtonClicked)
            }
        )
    }
}

@Preview
@Composable
private fun LightErrorFeedScreenPreview() {
    ErrorFeedScreenPreview()
}

@Preview
@Composable
private fun DarkErrorFeedScreenPreview() {
    ErrorFeedScreenPreview(isDarkThemeEnabled = true)
}

@Composable
private fun ErrorFeedScreenPreview(isDarkThemeEnabled: Boolean = false) {
    AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            ErrorFeedScreen(
                error = null,
                onEvent = {  }
            )
        }
    }
}