package com.chachadeveloper.designsystem.theme

import android.content.Context
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.util.Locale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

val Context.dataStore by preferencesDataStore("settings")
var Context.appTheme by mutableStateOf(ThemeMode.SYSTEM)
var Context.appLocale: Locale? by mutableStateOf(null)
var Context.systemLocale: Locale? by mutableStateOf(null)
enum class ThemeMode { LIGHT, NIGHT, SYSTEM }

private val LightAndroidColorScheme = lightColorScheme(
    primary = Red,
    onPrimary = White,
    primaryContainer = PinkLight,
    onPrimaryContainer = DarkRed,
    secondary = Rose,
    onSecondary = White,
    secondaryContainer = LightPink,
    onSecondaryContainer = DarkerRed,
    tertiary = PinkishRedLight,
    onTertiary = White,
    tertiaryContainer = PinkLight,
    onTertiaryContainer = DarkRed,
    error = ErrorRed,
    errorContainer = LightErrorPink,
    onError = White,
    onErrorContainer = DarkerErrorRed,
    background = White,
    onBackground = DarkGrayishBrown,
    surface = LightCream,
    onSurface = DarkGrayishBrown,
    surfaceVariant = LightPinkishGray,
    onSurfaceVariant = DarkGrayishPink3,
    outline = LightGray,
    inverseOnSurface = LightPinkishGray,
    inverseSurface = DarkGrayishBrown2,
    inversePrimary = LighterRose,
    surfaceTint = PinkishRed
)

private val LightDefaultColorScheme = lightColorScheme(
    primary = Red,
    onPrimary = White,
    primaryContainer = PinkLight,
    onPrimaryContainer = DarkRed,
    secondary = Rose,
    onSecondary = White,
    secondaryContainer = LightPink,
    onSecondaryContainer = DarkerRed,
    tertiary = PinkishRedLight,
    onTertiary = White,
    tertiaryContainer = PinkLight,
    onTertiaryContainer = DarkRed,
    error = ErrorRed,
    errorContainer = LightErrorPink,
    onError = White,
    onErrorContainer = DarkerErrorRed,
    background = White,
    onBackground = DarkGrayishBrown,
    surface = LightCream,
    onSurface = DarkGrayishBrown,
    surfaceVariant = LightPinkishGray,
    onSurfaceVariant = DarkGrayishPink3,
    outline = LightGray,
    inverseOnSurface = LightPinkishGray,
    inverseSurface = DarkGrayishBrown2,
    inversePrimary = LighterRose,
    surfaceTint = PinkishRed
)


private val DarkAndroidColorScheme = darkColorScheme(
    primary = DarkRed,
    onPrimary = DarkPlum,
    primaryContainer = DarkRaspberry,
    onPrimaryContainer = LightPink,
    secondary = LightPinkishRed,
    onSecondary = DarkFuchsia,
    secondaryContainer = DarkPink,
    onSecondaryContainer = LightPink,
    tertiary = LightPink2,
    onTertiary = DarkFuchsia2,
    tertiaryContainer = DarkPink2,
    onTertiaryContainer = LightPink,
    error = DarkSalmon,
    errorContainer = DarkRed2,
    onError = DarkRed3,
    onErrorContainer = LightPink3,
    background = DarkGrayishBrown,
    onBackground = LightGrayishPink,
    surface = DarkGrayishBrown2,
    onSurface = LightGrayishPink2,
    surfaceVariant = DarkGrayishPink3,
    onSurfaceVariant = LightGrayishPink3,
    outline = DarkGray,
    inverseOnSurface = DarkGrayishBrown3,
    inverseSurface = LightGrayishPink4,
    inversePrimary = PinkishRed,
    surfaceTint = LightPinkishRed2

)

private val DarkDefaultColorScheme = darkColorScheme(
    primary = DarkRed,
    onPrimary = DarkPlum,
    primaryContainer = DarkRaspberry,
    onPrimaryContainer = LightPink,
    secondary = LightPinkishRed,
    onSecondary = DarkFuchsia,
    secondaryContainer = DarkPink,
    onSecondaryContainer = LightPink,
    tertiary = LightPink2,
    onTertiary = DarkFuchsia2,
    tertiaryContainer = DarkPink2,
    onTertiaryContainer = LightPink,
    error = DarkSalmon,
    errorContainer = DarkRed2,
    onError = DarkRed3,
    onErrorContainer = LightPink3,
    background = DarkGrayishBrown,
    onBackground = LightGrayishPink,
    surface = DarkGrayishBrown2,
    onSurface = LightGrayishPink2,
    surfaceVariant = DarkGrayishPink3,
    onSurfaceVariant = LightGrayishPink3,
    outline = DarkGray,
    inverseOnSurface = DarkGrayishBrown3,
    inverseSurface = LightGrayishPink4,
    inversePrimary = PinkishRed,
    surfaceTint = LightPinkishRed2

)

/**
 * Light Android background theme
 */
val LightAndroidBackgroundTheme = BackgroundTheme(color = White)

/**
 * Dark Android background theme
 */
val DarkAndroidBackgroundTheme = BackgroundTheme(color = DarkGrayishBrown)

@Composable
fun isNightMode(): Boolean = when (LocalContext.current.appTheme) {
    ThemeMode.LIGHT -> false
    ThemeMode.NIGHT -> true
    else -> isSystemInDarkTheme()
}


@Composable
fun EMTheme(
    darkTheme: Boolean = false,
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        androidTheme -> if (darkTheme) DarkAndroidColorScheme else LightAndroidColorScheme
        !disableDynamicTheming && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        else -> if (darkTheme) DarkDefaultColorScheme else LightDefaultColorScheme
    }
    val view = LocalView.current
    val systemUiController = rememberSystemUiController()
    if (!view.isInEditMode) {
        SideEffect {
            systemUiController.setStatusBarColor(
                color =  Color.White
            )
            systemUiController.setNavigationBarColor(
                color =  Color.White
            )
            /* systemUiController.setStatusBarColor(
                 color = if (darkTheme) colorScheme.background else colorScheme.background
             )
             systemUiController.setNavigationBarColor(
                 color = if (darkTheme) colorScheme.background else Color.White

             )*/
        }
    }

    // Background theme
    val defaultBackgroundTheme = BackgroundTheme(
        color = colorScheme.surface,
        tonalElevation = 2.dp,
    )

    val backgroundTheme = when {
        androidTheme -> if (darkTheme) DarkAndroidBackgroundTheme else LightAndroidBackgroundTheme
        else -> defaultBackgroundTheme
    }

    CompositionLocalProvider(
        LocalBackgroundTheme provides backgroundTheme,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }


}


@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

suspend fun switchTheme(context: Context, mode: ThemeMode) {
    context.dataStore.edit {
        it[stringPreferencesKey("theme")] = mode.toString()
    }

    context.appTheme = mode
}

fun syncTheme(context: Context) {
    val currentValue = runBlocking { context.dataStore.data.first() }

    val mode = ThemeMode.valueOf(
        currentValue[stringPreferencesKey("theme")] ?: ThemeMode.SYSTEM.toString()
    )

    context.appTheme = mode
}
