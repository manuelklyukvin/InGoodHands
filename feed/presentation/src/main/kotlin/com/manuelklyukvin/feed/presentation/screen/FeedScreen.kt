package com.manuelklyukvin.feed.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manuelklyukvin.core.presentation.components.AppCard
import com.manuelklyukvin.core.presentation.components.AppIcon
import com.manuelklyukvin.core.presentation.components.AppImage
import com.manuelklyukvin.core.presentation.components.AppNavBar
import com.manuelklyukvin.core.presentation.components.AppScaffold
import com.manuelklyukvin.core.presentation.components.text_fields.AppTextField
import com.manuelklyukvin.core.presentation.theme.AppTheme
import com.manuelklyukvin.core.presentation.theme.LocalNavigationState
import com.manuelklyukvin.core.presentation.utils.noIndicationClickable
import com.manuelklyukvin.feed.presentation.R
import com.manuelklyukvin.feed.presentation.screen.models.FeedEvent
import com.manuelklyukvin.feed.presentation.screen.models.FeedPost
import com.manuelklyukvin.feed.presentation.screen.models.FeedState

@Composable
fun FeedScreen(state: FeedState, onEvent: (FeedEvent) -> Unit) {
    AppScaffold(
        topBar = {
            SearchBar(state, onEvent)
        },
        bottomBar = {
            AppNavBar()
        }
    ) {
        Content(state, onEvent)
    }
}

@Composable
private fun SearchBar(state: FeedState, onEvent: (FeedEvent) -> Unit) {
    Row(
        modifier = Modifier.padding(AppTheme.shapes.paddingSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppTextField(
            modifier = Modifier.weight(1f),
            state = state.search,
            hint = stringResource(R.string.feed_search)
        )
        Spacer(modifier = Modifier.width(AppTheme.shapes.paddingSmall))
        AppIcon(
            modifier = Modifier
                .size(AppTheme.shapes.iconMedium)
                .noIndicationClickable {
                    onEvent(FeedEvent.OnSearchButtonClicked)
                },
            model = painterResource(id = R.drawable.search),
            tint = AppTheme.colorScheme.primary
        )
    }
}

@Composable
private fun Content(state: FeedState, onEvent: (FeedEvent) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(horizontal = AppTheme.shapes.paddingSmall)
            .clip(AppTheme.shapes.roundedCornerShape),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)
    ) {
        items(state.postList) { post ->
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
                onEvent(FeedEvent.OnPostClicked(
                    navigationState = navigationState,
                    postId = post.id
                ))
            }
    ) {
        PostContent(post)
    }
}

@Composable
private fun PostContent(post: FeedPost) {
    AppImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp)
            .clip(AppTheme.shapes.roundedCornerShape),
        model = post.image,
        contentScale = ContentScale.Crop
    )
    Column(modifier = Modifier.padding(AppTheme.shapes.paddingSmall)) {
        Text(
            text = post.title,
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
                text = post.category,
                style = AppTheme.typography.body,
                color = AppTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = post.city,
            style = AppTheme.typography.label,
            color = AppTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun LightFeedScreen() {
    PreviewFeedScreen(isDarkThemeEnabled = false)
}

@Preview
@Composable
private fun DarkFeedScreen() {
    PreviewFeedScreen(isDarkThemeEnabled = true)
}

@Composable
private fun PreviewFeedScreen(isDarkThemeEnabled: Boolean) {
    AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            val post = FeedPost(
                image = R.drawable.kuzya,
                title = "Кузя",
                category = "Кошки",
                city = "Егорьевск"
            )
            val postList = List(10) {
                post
            }

            FeedScreen(
                state = FeedState(postList = postList),
                onEvent = { }
            )
        }
    }
}