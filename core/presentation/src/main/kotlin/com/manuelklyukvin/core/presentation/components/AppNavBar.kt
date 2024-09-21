package com.manuelklyukvin.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.manuelklyukvin.core.presentation.R
import com.manuelklyukvin.core.presentation.navigation.Screen
import com.manuelklyukvin.core.presentation.theme.AppTheme
import com.manuelklyukvin.core.presentation.theme.LocalNavigationState
import com.manuelklyukvin.core.presentation.utils.noIndicationClickable

@Composable
fun AppNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(AppTheme.shapes.sizeExtraLarge)
            .background(AppTheme.colorScheme.background),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppNavBarItem(
            icon = painterResource(id = R.drawable.home),
            label = stringResource(id = R.string.home_nav_button),
            route = Screen.Home,
            startRoute = Screen.Feed
        )
    }
}

@Composable
private fun AppNavBarItem(
    icon: Painter,
    label: String,
    route: Any,
    startRoute: Any
) {
    val navigationState = LocalNavigationState.current
    val navBackStackEntry by navigationState.navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route
    val isSelected = navBackStackEntry?.destination?.hierarchy?.any { destination ->
        destination.route?.contains(route.toString()) == true
    } ?: false

    val currentColor = if (isSelected) {
        AppTheme.colorScheme.primary
    } else {
        AppTheme.colorScheme.onBackground
    }

    Column(
        modifier = Modifier.noIndicationClickable {
            if (currentRoute?.contains(startRoute.toString()) == false) {
                navigationState.navigate(route)
            }
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppIcon(
            modifier = Modifier.size(AppTheme.shapes.sizeSmall),
            model = icon,
            tint = currentColor
        )
        Spacer(modifier = Modifier.height(AppTheme.shapes.paddingSmall))
        Text(
            text = label,
            style = AppTheme.typography.body,
            color = currentColor
        )
    }
}

@Preview
@Composable
private fun LightAppNavBarPreview() {
    AppTheme {
        AppNavBar()
    }
}

@Preview
@Composable
private fun DarkAppNavBarPreview() {
    AppTheme(isDarkThemeEnabled = true) {
        AppNavBar()
    }
}