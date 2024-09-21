package com.manuelklyukvin.feed.data.post

import com.manuelklyukvin.feed.data.post.models.DataFeedPost
import retrofit2.http.GET

interface FeedPostApiService {

    @GET("feed/posts")
    suspend fun getFeedPosts(): List<DataFeedPost>
}