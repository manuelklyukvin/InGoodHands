package com.manuelklyukvin.feed.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manuelklyukvin.core.presentation.components.AppCard
import com.manuelklyukvin.core.presentation.components.LoadingBox
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
internal fun LoadingFeedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.paddingSmall)
            .clip(AppTheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall),
    ) {
        repeat(3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(275.dp)
            ) {
                PostCard()
                Spacer(modifier = Modifier.width(AppTheme.shapes.paddingSmall))
                PostCard()
            }
        }
    }
}

@Composable
private fun RowScope.PostCard() {
    AppCard(
        modifier = Modifier
            .weight(1f)
            .height(275.dp)
    ) {
        LoadingBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
        )
        Column(modifier = Modifier.padding(AppTheme.shapes.paddingSmall)) {
            LoadingBox(
                modifier = Modifier.size(
                    height = AppTheme.shapes.sizeSmall,
                    width = AppTheme.shapes.sizeExtraLarge
                )
            )
            Spacer(modifier = Modifier.height(AppTheme.shapes.paddingSmall))
            LoadingBox(
                modifier = Modifier.size(
                    height = AppTheme.shapes.sizeExtraSmall,
                    width = AppTheme.shapes.sizeExtraLarge * 2
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            LoadingBox(
                modifier = Modifier.size(
                    height = AppTheme.shapes.sizeExtraSmall,
                    width = AppTheme.shapes.sizeExtraLarge
                )
            )
        }
    }
}

@Preview
@Composable
private fun LightLoadingFeedScreenPreview() {
    LoadingFeedScreenPreview()
}

@Preview
@Composable
private fun DarkLoadingFeedScreenPreview() {
    LoadingFeedScreenPreview(isDarkThemeEnabled = true)
}

@Composable
private fun LoadingFeedScreenPreview(isDarkThemeEnabled: Boolean = false) {
    AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            LoadingFeedScreen()
        }
    }
}