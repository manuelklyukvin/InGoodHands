package com.manuelklyukvin.feed.domain.post.models

data class DomainFeedPost(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val category: String,
    val city: String
)