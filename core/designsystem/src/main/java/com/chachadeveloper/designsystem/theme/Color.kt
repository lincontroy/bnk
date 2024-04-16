package com.chachadeveloper.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color


val primaryDarkVariant = Color(0xFF393939)
val PrimaryPink = Color(0xFFFE0A58)
val PrimaryGray = Color(0xFF828588)
val TextLightGray = Color(0xFFF7F7F7)
val Transparent = Color(0x00FFFFFF)
val TextWhite = Color(0xFFEEEEEE)
val DefaultBackground = Color(0xEBEBEBEB)
val HintGray = Color(0xFF8B8B8B)


val Blue200 = Color(0xFF73e8ff)
val Blue500 = Color(0xFF29b6f6)
val Blue700 = Color(0xFF0086c3)
val Teal200 = Color(0xFF03DAC5)

internal val Red = Color(0xFFA42A29)
internal val WhiteLight = Color(0xFFFFFFFF)
internal val PinkLight = Color(0xFFFFD9E2)
internal val DarkRedLight = Color(0xFF3E001D)
internal val Rose = Color(0xFF984063)
internal val DarkerRed = Color(0xFF3E001F)
internal val LightPinkLight = Color(0xFFFFD9E3)
internal val DarkerErrorRed = Color(0xFF410002)
internal val ErrorRed = Color(0xFFBA1A1A)
internal val LightErrorPink = Color(0xFFFFDAD6)
internal val DarkGrayishBrownLight = Color(0xFF201A1B)
internal val LightCream = Color(0xFFFFFBFF)
internal val LightPinkishGray = Color(0xFFF2DDE1)
internal val LightGray = Color(0xFFE9EBEA)
internal val LightPinkishGray2 = Color(0xFFFAEEEF)
internal val DarkGrayishBrown2Light = Color(0xFF352F30)
internal val LighterRose = Color(0xFFFFB1C8)
internal val BlackLight = Color(0xFF000000)
internal val PinkishRedLight = Color(0xFFB31B63)
internal val LightGrayishPinkLight = Color(0xFFD5C2C6)


internal val DarkRed = Color(0xFFDD5658)
internal val DarkPlum = Color(0xFF650033)
internal val DarkRaspberry = Color(0xFF8E004A)
internal val LightPink = Color(0xFFFFD9E2)
internal val LightPinkishRed = Color(0xFFFFB0C9)
internal val DarkFuchsia = Color(0xFF5D1134)
internal val DarkPink = Color(0xFF7A294B)
internal val LightPink2 = Color(0xFFFFB0C8)
internal val DarkFuchsia2 = Color(0xFF5E1133)
internal val DarkPink2 = Color(0xFF7B2949)
internal val DarkSalmon = Color(0xFFFFB4AB)
internal val DarkRed2 = Color(0xFF93000A)
internal val DarkRed3 = Color(0xFF690005)
internal val LightPink3 = Color(0xFFFFDAD6)
internal val DarkGrayishBrown = Color(0xFF21201E)
internal val LightGrayishPink = Color(0xFFEBE0E1)
internal val DarkGrayishBrown2 = Color(0xFF201A1B)
internal val LightGrayishPink2 = Color(0xFFEBE0E1)
internal val DarkGrayishPink3 = Color(0xFF514347)
internal val LightGrayishPink3 = Color(0xFFD5C2C6)
internal val DarkGray = Color(0xFF373737)
internal val DarkGrayishBrown3 = Color(0xFF201A1B)
internal val LightGrayishPink4 = Color(0xFFEBE0E1)
internal val PinkishRed = Color(0xFFB31B63)
internal val Black = Color(0xFF000000)
internal val LightPinkishRed2 = Color(0xFFFFB1C8)
internal val DarkGrayishPink4 = Color(0xFF514347)
internal val Black2 = Color(0xFF000000)


val colorBackground
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.surface

val colorOnBackground
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.onSurface

val colorButton
    @Composable
    @ReadOnlyComposable
    get() =
        MaterialTheme.colorScheme.secondaryContainer

val colorOnButton
    @Composable
    @ReadOnlyComposable
    get() =
        MaterialTheme.colorScheme.onSurfaceVariant

val colorEditor
    @Composable
    @ReadOnlyComposable
    get() =
        MaterialTheme.colorScheme.surface

val colorOnEditor
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.onSurface


