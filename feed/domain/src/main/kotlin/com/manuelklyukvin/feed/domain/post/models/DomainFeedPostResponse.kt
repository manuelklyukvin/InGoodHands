package com.manuelklyukvin.feed.domain.post.models

data class DomainFeedPostResponse(
    val domainFeedPosts: List<DomainFeedPost>,
    val hasNextPage: Boolean
)