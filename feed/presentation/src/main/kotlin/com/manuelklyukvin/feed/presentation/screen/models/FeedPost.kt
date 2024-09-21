package com.manuelklyukvin.feed.presentation.screen.models

data class FeedPost(
    val id: Int = 0,
    val image: Any,
    val title: String,
    val category: String,
    val city: String
)