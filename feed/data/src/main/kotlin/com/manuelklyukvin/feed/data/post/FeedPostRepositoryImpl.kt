package com.manuelklyukvin.feed.data.post

import com.manuelklyukvin.core.domain.result.Result
import com.manuelklyukvin.feed.data.post.models.toDomain
import com.manuelklyukvin.feed.domain.post.FeedPostRepository
import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost

class FeedPostRepositoryImpl(private val feedPostApiService: FeedPostApiService) : FeedPostRepository {

    override suspend fun getFeedPosts(): Result<List<DomainFeedPost>, Unit> {
        return try {
            val domainFeedPostList = feedPostApiService.getFeedPosts().map { post ->
                post.toDomain()
            }
            Result.Success(domainFeedPostList)
        } catch (e : Exception) {
            Result.Error(Unit)
        }
    }
}