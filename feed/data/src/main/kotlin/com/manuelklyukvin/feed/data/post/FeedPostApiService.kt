package com.manuelklyukvin.feed.data.post

import com.manuelklyukvin.feed.data.post.models.DataFeedPost
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedPostApiService {

    @GET("feed/posts")
    suspend fun getFeedPosts(
        @Query("postCount") postCount: Int,
        @Query("pageNumber") pageNumber: Int
    ): List<DataFeedPost>
}