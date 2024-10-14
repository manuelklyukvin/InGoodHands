package com.manuelklyukvin.feed.presentation.di

import com.manuelklyukvin.core.data.database.ApiClient
import com.manuelklyukvin.core.domain.post.GetCategoryNameUseCase
import com.manuelklyukvin.feed.data.post.FeedPostApiService
import com.manuelklyukvin.feed.data.post.FeedPostRepositoryImpl
import com.manuelklyukvin.feed.data.post.GetFinalFeedPostUseCaseImpl
import com.manuelklyukvin.feed.domain.post.FeedPostRepository
import com.manuelklyukvin.feed.domain.post.GetFeedPostsUseCase
import com.manuelklyukvin.feed.domain.post.GetFinalFeedPostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object FeedPostModule {

    @Provides
    fun provideFeedPostApiService(): FeedPostApiService = ApiClient.retrofit.create(FeedPostApiService::class.java)

    @Provides
    fun provideFeedPostRepository(feedPostApiService: FeedPostApiService): FeedPostRepository {
        return FeedPostRepositoryImpl(feedPostApiService)
    }

    @Provides
    fun provideGetFinalFeedPostUseCase(getCategoryNameUseCase: GetCategoryNameUseCase): GetFinalFeedPostUseCase {
        return GetFinalFeedPostUseCaseImpl(getCategoryNameUseCase)
    }

    @Provides
    fun provideGetFeedPostsUseCase(
        feedPostRepository: FeedPostRepository,
        getFinalFeedPostUseCase: GetFinalFeedPostUseCase
    ) = GetFeedPostsUseCase(
        feedPostRepository = feedPostRepository,
        getFinalFeedPostUseCase = getFinalFeedPostUseCase
    )
}