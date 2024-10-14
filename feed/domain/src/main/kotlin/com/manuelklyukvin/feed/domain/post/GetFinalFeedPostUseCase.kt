package com.manuelklyukvin.feed.domain.post

import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost

interface GetFinalFeedPostUseCase {

    operator fun invoke(post: DomainFeedPost): DomainFeedPost
}