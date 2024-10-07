package com.manuelklyukvin.feed.data.post.models

import com.google.gson.annotations.SerializedName
import com.manuelklyukvin.feed.domain.post.models.DomainFeedPost

data class DataFeedPost(
    val id: Int,
    @SerializedName("image_url") val imageUrl: String,
    val title: String,
    val category: String,
    val city: String
)

fun DataFeedPost.toDomain() = DomainFeedPost(
    id = id,
    imageUrl = imageUrl,
    title = title,
    category = category,
    city = city
)