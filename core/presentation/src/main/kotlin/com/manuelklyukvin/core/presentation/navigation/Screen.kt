package com.manuelklyukvin.core.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object Home : Screen
    @Serializable
    data object Feed : Screen
    @Serializable
    data class Post(val postId: Int) : Screen
}