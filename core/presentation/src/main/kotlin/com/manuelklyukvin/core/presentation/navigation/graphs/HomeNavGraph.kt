package com.manuelklyukvin.core.presentation.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.manuelklyukvin.core.presentation.navigation.Screen

fun NavGraphBuilder.homeNavGraph(
    feedScreen: @Composable () -> Unit,
    postScreen: @Composable (Int) -> Unit
) {
    navigation<Screen.Home>(startDestination = Screen.Feed) {
        composable<Screen.Feed> {
            feedScreen()
        }
        composable<Screen.Post> {
            val postId = it.toRoute<Screen.Post>().postId
            postScreen(postId)
        }
    }
}