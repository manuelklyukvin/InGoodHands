package com.manuelklyukvin.feed.data.post

import com.manuelklyukvin.core.domain.result.Result
import com.manuelklyukvin.feed.data.post.models.toDomain
import com.manuelklyukvin.feed.domain.post.FeedPostRepository
import com.manuelklyukvin.feed.domain.post.models.DomainFeedPostResponse

class FeedPostRepositoryImpl(private val feedPostApiService: FeedPostApiService) : FeedPostRepository {

    override suspend fun getFeedPosts(pageNumber: Int): Result<DomainFeedPostResponse, String?> {
        try {
            val dataFeedPosts = feedPostApiService.getFeedPosts(
                postCount = POST_COUNT + 1,
                pageNumber = pageNumber
            )
            val domainFeedPosts = dataFeedPosts.take(POST_COUNT).map { dataFeedPost ->
                dataFeedPost.toDomain()
            }
            val hasNextPage = dataFeedPosts.size > POST_COUNT

            return Result.Success(
                DomainFeedPostResponse(
                    domainFeedPosts = domainFeedPosts,
                    hasNextPage = hasNextPage
                )
            )
        } catch (e : Exception) {
            return Result.Error(e.localizedMessage)
        }
    }

    private companion object {

        const val POST_COUNT = 20
    }
}