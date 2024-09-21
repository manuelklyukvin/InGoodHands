package com.manuelklyukvin.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.manuelklyukvin.core.presentation.navigation.NavigationState
import com.manuelklyukvin.core.presentation.navigation.rememberNavigationState
import com.manuelklyukvin.core.presentation.theme.resources.Colors
import com.manuelklyukvin.core.presentation.theme.resources.Fonts

val LocalNavigationState = compositionLocalOf<NavigationState> {
    error("No NavigationState provided")
}

private val localColors = staticCompositionLocalOf<AppColorScheme> {
    error("No colors provided")
}

private val localShapes = staticCompositionLocalOf<AppShapes> {
    error("No shapes provided")
}

private val localTypography = staticCompositionLocalOf<AppTypography> {
    error("No typography provided")
}

@Composable
fun AppTheme(
    isDarkThemeEnabled: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val lightColorScheme = AppColorScheme(
        primary = Colors.primaryLight,
        onPrimary = Colors.onPrimaryLight,
        secondary = Colors.secondaryLight,
        onSecondary = Colors.onSecondaryLight,
        error = Colors.errorLight,
        background = Colors.backgroundLight,
        onBackground = Colors.onBackgroundLight,
        surface = Colors.surfaceLight,
        onSurface = Colors.onSurfaceLight,
        outline = Colors.outlineLight
    )

    val darkColorScheme = AppColorScheme(
        primary = Colors.primaryDark,
        onPrimary = Colors.onPrimaryDark,
        secondary = Colors.secondaryDark,
        onSecondary = Colors.onSecondaryDark,
        error = Colors.errorDark,
        background = Colors.backgroundDark,
        onBackground = Colors.onBackgroundDark,
        surface = Colors.surfaceDark,
        onSurface = Colors.onSurfaceDark,
        outline = Colors.outlineDark
    )

    val colorScheme = if (isDarkThemeEnabled) {
        darkColorScheme
    } else {
        lightColorScheme
    }

    val shapes = AppShapes(
        paddingExtraSmall = 4.dp,
        paddingSmall = 8.dp,
        paddingMedium = 12.dp,
        paddingLarge = 16.dp,
        paddingExtraLarge = 20.dp,
        iconExtraSmall = 16.dp,
        iconSmall = 24.dp,
        iconMedium = 32.dp,
        iconLarge = 48.dp,
        iconExtraLarge = 64.dp,
        roundedCornerShape = RoundedCornerShape(12.dp)
    )

    val typography = AppTypography(
        headline = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            fontSize = 24.sp
        ),
        title = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            fontSize = 16.sp
        ),
        body = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            fontSize = 14.sp
        ),
        label = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            fontSize = 12.sp
        )
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = colorScheme.background,
        darkIcons = !isDarkThemeEnabled
    )

    CompositionLocalProvider(
        LocalNavigationState provides rememberNavigationState(),
        localColors provides colorScheme,
        localShapes provides shapes,
        localTypography provides typography,
        content = content
    )
}

object AppTheme {

    val colorScheme: AppColorScheme
        @Composable
        get() = localColors.current

    val shapes: AppShapes
        @Composable
        get() = localShapes.current

    val typography: AppTypography
        @Composable
        get() = localTypography.current
}