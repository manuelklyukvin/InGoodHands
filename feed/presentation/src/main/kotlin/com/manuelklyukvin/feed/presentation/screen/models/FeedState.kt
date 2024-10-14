package com.manuelklyukvin.feed.presentation.screen.models

import androidx.compose.foundation.text.input.TextFieldState

data class FeedState(
    val viewState: FeedViewState = FeedViewState.Initial,
    val searchState: TextFieldState = TextFieldState(),
    val feedPosts: List<FeedPost> = emptyList(),
    val currentPage: Int = 0,
    val isPreviousPageButtonShown: Boolean = false,
    val isNextPageButtonShown: Boolean = false
)