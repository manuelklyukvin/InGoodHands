package com.manuelklyukvin.feed.presentation.screen

import androidx.lifecycle.ViewModel
import com.manuelklyukvin.core.presentation.navigation.NavigationState
import com.manuelklyukvin.core.presentation.navigation.Screen
import com.manuelklyukvin.feed.presentation.R
import com.manuelklyukvin.feed.presentation.screen.models.FeedEvent
import com.manuelklyukvin.feed.presentation.screen.models.FeedPost
import com.manuelklyukvin.feed.presentation.screen.models.FeedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(FeedState())
    val state: StateFlow<FeedState>
        get() = _state.asStateFlow()

    init {
        val post = FeedPost(
            image = R.drawable.kuzya,
            title = "Кузя",
            category = "Кошки",
            city = "Егорьевск"
        )
        val postList = List(10) {
            post
        }

        _state.value = state.value.copy(postList = postList)
    }

    fun onEvent(event: FeedEvent) = when (event) {
        FeedEvent.OnSearchButtonClicked -> onSearchButtonClicked()
        is FeedEvent.OnPostClicked -> onPostClicked(
            navigationState = event.navigationState,
            postId = event.postId
        )
    }

    private fun onSearchButtonClicked() {

    }

    private fun onPostClicked(navigationState: NavigationState, postId: Int) {
        navigationState.navigate(Screen.Post(postId))
    }
}