package com.manuelklyukvin.feed.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuelklyukvin.core.domain.post.GetCategoryNameUseCase
import com.manuelklyukvin.core.domain.result.Result
import com.manuelklyukvin.core.presentation.navigation.NavigationState
import com.manuelklyukvin.core.presentation.navigation.Screen
import com.manuelklyukvin.feed.domain.post.GetFeedPostsUseCase
import com.manuelklyukvin.feed.presentation.screen.models.FeedEvent
import com.manuelklyukvin.feed.presentation.screen.models.FeedState
import com.manuelklyukvin.feed.presentation.screen.models.FeedViewState
import com.manuelklyukvin.feed.presentation.screen.models.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getFeedPostsUseCase: GetFeedPostsUseCase,
    private val getCategoryNameUseCase: GetCategoryNameUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(FeedState())
    val state: StateFlow<FeedState>
        get() = _state.asStateFlow()

    init {
        loadFeedPosts()
    }

    fun onEvent(event: FeedEvent) = when (event) {
        is FeedEvent.OnSearchButtonClicked -> onSearchButtonClicked()
        is FeedEvent.OnPostClicked -> onPostClicked(
            navigationState = event.navigationState,
            postId = event.postId
        )
        is FeedEvent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadFeedPosts() {
        _state.value = state.value.copy(viewState = FeedViewState.Loading)

        viewModelScope.launch {
            delay(3000)
            when (val getFeedPostsResult = getFeedPostsUseCase()) {
                is Result.Success -> {
                    val feedPosts = getFeedPostsResult.data.map { feedPost ->
                        feedPost.toPresentation().copy(category = getCategoryNameUseCase(feedPost.category))
                    }
                    _state.value = state.value.copy(
                        viewState = FeedViewState.Content,
                        feedPosts = feedPosts
                    )
                }
                is Result.Error -> {
                    _state.value = state.value.copy(viewState = FeedViewState.Error(getFeedPostsResult.error))
                }
            }
        }
    }

    private fun onSearchButtonClicked() {

    }

    private fun onPostClicked(navigationState: NavigationState, postId: Int) {
        navigationState.navigate(Screen.Post(postId))
    }

    private fun onRetryButtonClicked() {
        loadFeedPosts()
    }
}