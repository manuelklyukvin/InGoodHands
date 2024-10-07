package com.manuelklyukvin.feed.presentation.screen.models

import com.manuelklyukvin.core.presentation.navigation.NavigationState

sealed interface FeedEvent {

    data object OnSearchButtonClicked : FeedEvent
    data class OnPostClicked(
        val navigationState: NavigationState,
        val postId: Int
    ) : FeedEvent
    data object OnRetryButtonClicked : FeedEvent
}