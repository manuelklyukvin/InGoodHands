package com.manuelklyukvin.feed.domain.post

import com.manuelklyukvin.core.domain.result.Result
import com.manuelklyukvin.feed.domain.post.models.DomainFeedPostResponse

interface FeedPostRepository {

    suspend fun getFeedPosts(pageNumber: Int): Result<DomainFeedPostResponse, String?>
}