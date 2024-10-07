package com.manuelklyukvin.feed.presentation.screen.models

sealed interface FeedViewState {

    data object Initial : FeedViewState
    data object Content : FeedViewState
    data object Loading : FeedViewState
    data class Error(val error: String?) : FeedViewState
}