package com.manuelklyukvin.feed.domain.post

class GetFeedPostsUseCase(private val feedPostRepository: FeedPostRepository) {

    suspend operator fun invoke() = feedPostRepository.getFeedPosts()
}