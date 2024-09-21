package com.manuelklyukvin.ingoodhands

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.manuelklyukvin.core.presentation.navigation.graphs.AppNavGraph
import com.manuelklyukvin.core.presentation.theme.AppTheme
import com.manuelklyukvin.feed.presentation.screen.FeedScreen
import com.manuelklyukvin.feed.presentation.screen.FeedViewModel

@Composable
fun AppScreen() {
    var isDarkThemeEnabled by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        AppTheme(isDarkThemeEnabled = isDarkThemeEnabled) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = AppTheme.colorScheme.background
            ) {
                AppNavGraph(
                    feedScreen = {
                        val viewModel = hiltViewModel<FeedViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()
                        val onEvent = viewModel::onEvent

                        FeedScreen(state, onEvent)
                    },
                    postScreen = { postId ->

                    }
                )
            }
        }
        Button(
            modifier = Modifier.size(50.dp),
            onClick = {
                isDarkThemeEnabled = !isDarkThemeEnabled
            },
            content = {  }
        )
    }
}