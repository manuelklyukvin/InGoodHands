package com.manuelklyukvin.feed.data.post

import com.manuelklyukvin.core.data.database.ApiClient
import com.manuelklyukvin.core.domain.result.Result
import com.manuelklyukvin.feed.data.post.models.toDomain
import com.manuelklyukvin.feed.domain.post.FeedPostRepository
import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost

class FeedPostRepositoryImpl(private val feedPostApiService: FeedPostApiService) : FeedPostRepository {

    override suspend fun getFeedPosts(): Result<List<DomainFeedPost>, String?> {
        return try {
            val domainFeedPosts = feedPostApiService.getFeedPosts(POST_COUNT).map { dataFeedPost ->
                dataFeedPost.toDomain().copy(imageUrl = ApiClient.BASE_URL + dataFeedPost.imageUrl)
            }
            Result.Success(domainFeedPosts)
        } catch (e : Exception) {
            Result.Error(e.message)
        }
    }

    private companion object {

        const val POST_COUNT = 20
    }
}