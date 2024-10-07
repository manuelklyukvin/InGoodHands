package com.manuelklyukvin.feed.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manuelklyukvin.core.presentation.components.AppCard
import com.manuelklyukvin.core.presentation.components.AppImage
import com.manuelklyukvin.core.presentation.theme.AppTheme
import com.manuelklyukvin.core.presentation.theme.LocalNavigationState
import com.manuelklyukvin.core.presentation.utils.noIndicationClickable
import com.manuelklyukvin.feed.presentation.R
import com.manuelklyukvin.feed.presentation.screen.models.FeedEvent
import com.manuelklyukvin.feed.presentation.screen.models.FeedPost
import com.manuelklyukvin.feed.presentation.screen.models.FeedState

@Composable
internal fun ContentFeedScreen(state: FeedState, onEvent: (FeedEvent) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.paddingSmall)
            .clip(AppTheme.shapes.roundedCornerShape),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)
    ) {
        items(state.feedPosts) { post ->
            PostCard(post, onEvent)
        }
    }
}

@Composable
private fun PostCard(post: FeedPost, onEvent: (FeedEvent) -> Unit) {
    val navigationState = LocalNavigationState.current

    AppCard(
        modifier = Modifier
            .height(275.dp)
            .noIndicationClickable {
                onEvent(
                    FeedEvent.OnPostClicked(
                        navigationState = navigationState,
                        postId = post.id
                    )
                )
            }
    ) {
        PostContent(post)
    }
}

@Composable
private fun PostContent(post: FeedPost) {
    with(post) {
        AppImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
                .clip(AppTheme.shapes.roundedCornerShape),
            model = imageUrl,
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(AppTheme.shapes.paddingSmall)) {
            Text(
                text = title,
                style = AppTheme.typography.title,
                color = AppTheme.colorScheme.primary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row {
                Text(
                    text = stringResource(R.string.feed_category),
                    style = AppTheme.typography.body,
                    color = AppTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(AppTheme.shapes.paddingExtraSmall))
                Text(
                    text = category,
                    style = AppTheme.typography.body,
                    color = AppTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = city,
                style = AppTheme.typography.label,
                color = AppTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
private fun LightContentFeedScreen() {
    PreviewContentFeedScreen()
}

@Preview
@Composable
private fun DarkContentFeedScreen() {
    PreviewContentFeedScreen(isDarkThemeEnabled = true)
}

@Composable
private fun PreviewContentFeedScreen(isDarkThemeEnabled: Boolean = false) {
    AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            val postList = List(10) {
                FeedPost(
                    id = 0,
                    imageUrl = "",
                    title = "Кузя",
                    category = "Кошки",
                    city = "Егорьевск"
                )
            }

            ContentFeedScreen(
                state = FeedState(feedPosts = postList),
                onEvent = { }
            )
        }
    }
}