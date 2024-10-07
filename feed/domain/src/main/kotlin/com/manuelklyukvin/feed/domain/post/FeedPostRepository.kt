package com.manuelklyukvin.feed.domain.post

import com.manuelklyukvin.core.domain.result.Result
import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost

interface FeedPostRepository {

    suspend fun getFeedPosts(): Result<List<DomainFeedPost>, String?>
}