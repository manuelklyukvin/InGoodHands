package com.manuelklyukvin.feed.presentation.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.manuelklyukvin.core.presentation.components.AppIcon
import com.manuelklyukvin.core.presentation.components.AppNavBar
import com.manuelklyukvin.core.presentation.components.AppScaffold
import com.manuelklyukvin.core.presentation.components.text_fields.AppTextField
import com.manuelklyukvin.core.presentation.theme.AppTheme
import com.manuelklyukvin.core.presentation.utils.noIndicationClickable
import com.manuelklyukvin.feed.presentation.R
import com.manuelklyukvin.feed.presentation.screen.models.FeedEvent
import com.manuelklyukvin.feed.presentation.screen.models.FeedState
import com.manuelklyukvin.feed.presentation.screen.models.FeedViewState

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
        when (state.viewState) {
            is FeedViewState.Initial -> {  }
            is FeedViewState.Loading -> LoadingFeedScreen()
            is FeedViewState.Content -> ContentFeedScreen(state, onEvent)
            is FeedViewState.Error -> ErrorFeedScreen(state.viewState.error, onEvent)
        }
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
            state = state.searchState,
            hint = stringResource(R.string.feed_search)
        )
        Spacer(modifier = Modifier.width(AppTheme.shapes.paddingSmall))
        AppIcon(
            modifier = Modifier
                .size(AppTheme.shapes.sizeMedium)
                .noIndicationClickable {
                    onEvent(FeedEvent.OnSearchButtonClicked)
                },
            model = painterResource(id = R.drawable.search),
            tint = AppTheme.colorScheme.primary
        )
    }
}