package com.manuelklyukvin.feed.domain.post

import com.manuelklyukvin.core.domain.result.Result
import com.manuelklyukvin.feed.domain.post.models.DomainFeedPostResponse

class GetFeedPostsUseCase(
    private val feedPostRepository: FeedPostRepository,
    private val getFinalFeedPostUseCase: GetFinalFeedPostUseCase
) {

    suspend operator fun invoke(pageNumber: Int): Result<DomainFeedPostResponse, String?> {
        return when (val result = feedPostRepository.getFeedPosts(pageNumber)) {
            is Result.Success -> Result.Success(
                DomainFeedPostResponse(
                    domainFeedPosts = result.data.domainFeedPosts.map { domainFeedPost ->
                        getFinalFeedPostUseCase(domainFeedPost)
                    },
                    hasNextPage = result.data.hasNextPage
                )
            )
            is Result.Error -> result
        }
    }
}