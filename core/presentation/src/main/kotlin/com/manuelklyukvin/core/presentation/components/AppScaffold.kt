package com.manuelklyukvin.core.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.manuelklyukvin.core.presentation.theme.AppTheme

@Composable
fun AppScaffold(
    topBar: @Composable () -> Unit = {  },
    bottomBar: @Composable () -> Unit = {  },
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppTheme.colorScheme.background,
        topBar = {
            topBar()
        },
        bottomBar = {
            bottomBar()
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            content()
        }
    }
}