package com.manuelklyukvin.feed.presentation.screen.models

import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost

data class FeedPost(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val category: String,
    val city: String
)

fun DomainFeedPost.toPresentation() = FeedPost(
    id = id,
    imageUrl = imageUrl,
    title = title,
    category = category,
    city = city
)