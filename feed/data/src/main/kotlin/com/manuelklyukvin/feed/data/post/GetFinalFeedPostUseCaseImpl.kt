package com.manuelklyukvin.feed.data.post

import com.manuelklyukvin.core.data.database.ApiClient
import com.manuelklyukvin.core.domain.post.GetCategoryNameUseCase
import com.manuelklyukvin.feed.domain.post.GetFinalFeedPostUseCase
import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost

class GetFinalFeedPostUseCaseImpl(
    private val getCategoryNameUseCase: GetCategoryNameUseCase
) : GetFinalFeedPostUseCase {

    override fun invoke(post: DomainFeedPost) = post.copy(
        imageUrl = ApiClient.BASE_URL + post.imageUrl,
        category = getCategoryNameUseCase(post.category)
    )
}