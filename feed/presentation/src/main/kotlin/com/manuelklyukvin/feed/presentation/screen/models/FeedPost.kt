package com.manuelklyukvin.feed.presentation.screen.models

import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost
import com.manuelklyukvin.feed.presentation.R

data class FeedPost(
    val id: Int = 0,
    val image: Any,
    val title: String,
    val category: String,
    val city: String
)

fun DomainFeedPost.toPresentation(): FeedPost {
    return FeedPost(
        id = id,
        image = R.drawable.kuzya,
        title = title,
        category = category,
        city = city
    )
}