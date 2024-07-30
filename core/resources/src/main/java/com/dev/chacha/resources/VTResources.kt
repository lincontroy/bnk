package com.dev.chacha.resources

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLayoutDirection
import com.chachadeveloper.designsystem.theme.EMTheme
import com.dev.chacha.resources.strings.IStringResources
import com.vunatec.resources.util.LanguageCode
import com.dev.chacha.resources.util.LocalizationManager

private val localDrawableResources = staticCompositionLocalOf { DrawableResources() }
private val localStringResources = staticCompositionLocalOf<IStringResources> {
    error("CompositionLocal IStringResources not present")
}

@Composable
fun EquityMobileTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    languageCode: LanguageCode = LanguageCode.EN,
    content: @Composable () -> Unit,
) {
    val drawableResources = if (useDarkTheme) BpDrawableDarkResources else DrawableResources()

    CompositionLocalProvider(
        localDrawableResources provides drawableResources,
        localStringResources provides LocalizationManager.getStringResources(languageCode),
        LocalLayoutDirection provides LocalizationManager.getLayoutDirection(languageCode)
    ) {
        EMTheme(darkTheme  = useDarkTheme) {
            content()
        }
    }
}

object Resources {
    val images: DrawableResources
        @Composable
        @ReadOnlyComposable
        get() = localDrawableResources.current

    val strings: IStringResources
        @Composable
        @ReadOnlyComposable
        get() = localStringResources.current
}
