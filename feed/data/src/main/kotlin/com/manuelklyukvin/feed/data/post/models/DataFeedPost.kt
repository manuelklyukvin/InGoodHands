package com.manuelklyukvin.feed.data.post.models

import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost

data class DataFeedPost(
    val id: Int,
    val title: String,
    val category: String,
    val city: String
)

fun DataFeedPost.toDomain(): DomainFeedPost {
    return DomainFeedPost(
        id = id,
        title = title,
        category = category,
        city = city
    )
}