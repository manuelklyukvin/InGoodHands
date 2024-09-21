package com.manuelklyukvin.feed.presentation.screen.models

import androidx.compose.foundation.text.input.TextFieldState

data class FeedState(
    val viewState: FeedViewState = FeedViewState.CONTENT,
    val search: TextFieldState = TextFieldState(),
    val postList: List<FeedPost> = emptyList()
)