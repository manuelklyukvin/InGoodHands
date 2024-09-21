package com.manuelklyukvin.core.presentation.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.manuelklyukvin.core.presentation.navigation.Screen
import com.manuelklyukvin.core.presentation.theme.LocalNavigationState
import com.manuelklyukvin.core.presentation.theme.resources.Animations

@Composable
fun AppNavGraph(
    feedScreen: @Composable () -> Unit,
    postScreen: @Composable (Int) -> Unit
) {
    NavHost(
        navController = LocalNavigationState.current.navController,
        startDestination = Screen.Home,
        enterTransition = Animations.enterTransition,
        exitTransition = Animations.exitTransition,
        popEnterTransition = Animations.enterTransition,
        popExitTransition = Animations.exitTransition
    ) {
        homeNavGraph(
            feedScreen = {
                feedScreen()
            },
            postScreen = { postId ->
                postScreen(postId)
            }
        )
    }
}