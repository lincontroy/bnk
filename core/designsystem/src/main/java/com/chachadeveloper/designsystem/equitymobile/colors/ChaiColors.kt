
package com.chachadeveloper.designsystem.equitymobile.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiBlack
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiBlue
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiCoal
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiDarkGrey
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiGrey
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiGrey90
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiLightGrey
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiLightGrey90
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiRed
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiSmokeyGrey
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiSubtleGrey
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiTeal
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiTeal90
import com.chachadeveloper.designsystem.equitymobile.atoms.ChaiWhite

@Immutable
data class ChaiColors(
    val primary: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val surfaces: Color = Color.Unspecified,
    val cardsBackground: Color = Color.Unspecified,
    val cardsBorderColor: Color = Color.Unspecified,
    val bottomNavBorderColor: Color = Color.Unspecified,
    val activeBottomNavIconColor: Color = Color.Unspecified,
    val activeBottomNavTextColor: Color = Color.Unspecified,
    val inactiveBottomNavIconColor: Color = Color.Unspecified,
    val bottomNavBackgroundColor: Color = Color.Unspecified,
    val textTitlePrimaryColor: Color = Color.Unspecified,
    val textBoldColor: Color = Color.Unspecified,
    val textNormalColor: Color = Color.Unspecified,
    val textWeakColor: Color = Color.Unspecified,
    val textLabelAndHeadings: Color = Color.Unspecified,
    val linkTextColorPrimary: Color = Color.Unspecified,
    val secondaryButtonColor: Color = Color.Unspecified,
    val secondaryButtonTextColor: Color = Color.Unspecified,
    val outlinedButtonBackgroundColor: Color = Color.Unspecified,
    val outlinedButtonTextColor: Color = Color.Unspecified,
    val textButtonColor: Color = Color.Unspecified,
    val radioButtonColors: Color = Color.Unspecified,
    val toggleOffBackgroundColor: Color = Color.Unspecified,
    val toggleOffIconBackgroundColor: Color = Color.Unspecified,
    val toggleOffIconColor: Color = Color.Unspecified,
    val toggleOnBackgroundColor: Color = Color.Unspecified,
    val toggleOnIconBackgroundColor: Color = Color.Unspecified,
    val toggleOnIconColor: Color = Color.Unspecified,
    val loadingStateOnCardsColor: Color = Color.Unspecified,
    val eventDaySelectorActiveSurfaceColor: Color = Color.Unspecified,
    val eventDaySelectorInactiveSurfaceColor: Color = Color.Unspecified,
    val eventDaySelectorInactiveTextColor: Color = Color.Unspecified,
    val eventDaySelectorActiveTextColor: Color = Color.Unspecified,
    val badgeBackgroundColor: Color = Color.Unspecified,
    val textFieldBackgroundColor: Color = Color.Unspecified,
    val textFieldBorderColor: Color = Color.Unspecified,
    val bottomSheetBackgroundColor: Color = Color.Unspecified,
    val inactiveMultiSelectButtonBorderColor: Color = Color.Unspecified
)

val LocalChaiColorsPalette = staticCompositionLocalOf { ChaiColors() }

val ChaiLightColorPalette = ChaiColors(
    primary = ChaiBlue,
    background = ChaiWhite,
    surfaces = ChaiLightGrey,
    cardsBackground = ChaiWhite,
    cardsBorderColor = ChaiLightGrey,
    bottomNavBorderColor = ChaiLightGrey,
    activeBottomNavIconColor = ChaiBlue,
    inactiveBottomNavIconColor = ChaiGrey90,
    bottomNavBackgroundColor = ChaiWhite,
    activeBottomNavTextColor = ChaiRed,
    textTitlePrimaryColor = ChaiBlue,
    textBoldColor = ChaiGrey90,
    textNormalColor = ChaiGrey90,
    textWeakColor = ChaiSmokeyGrey,
    textLabelAndHeadings = ChaiBlue,
    linkTextColorPrimary = ChaiBlue,
    secondaryButtonColor = ChaiBlue,
    secondaryButtonTextColor = ChaiLightGrey90,
    outlinedButtonBackgroundColor = ChaiWhite,
    outlinedButtonTextColor = ChaiCoal,
    textButtonColor = ChaiBlue,
    radioButtonColors = ChaiSmokeyGrey,
    toggleOffBackgroundColor = ChaiGrey90,
    toggleOffIconBackgroundColor = ChaiWhite,
    toggleOffIconColor = ChaiGrey90,
    toggleOnBackgroundColor = ChaiRed,
    toggleOnIconBackgroundColor = ChaiWhite,
    toggleOnIconColor = ChaiRed,
    loadingStateOnCardsColor = ChaiGrey,
    eventDaySelectorActiveSurfaceColor = ChaiRed,
    eventDaySelectorInactiveSurfaceColor = ChaiTeal90,
    eventDaySelectorActiveTextColor = ChaiWhite,
    eventDaySelectorInactiveTextColor = ChaiGrey90,
    badgeBackgroundColor = ChaiCoal,
    textFieldBackgroundColor = ChaiLightGrey,
    textFieldBorderColor = ChaiLightGrey,
    bottomSheetBackgroundColor = ChaiLightGrey90,
    inactiveMultiSelectButtonBorderColor = ChaiGrey90
)

val ChaiDarkColorPalette = ChaiColors(
    primary = ChaiBlack,
    background = ChaiGrey90,
    surfaces = ChaiBlack,
    cardsBackground = ChaiBlack,
    cardsBorderColor = ChaiSubtleGrey,
    bottomNavBorderColor = ChaiGrey90,
    activeBottomNavIconColor = ChaiTeal,
    inactiveBottomNavIconColor = ChaiWhite,
    bottomNavBackgroundColor = ChaiBlack,
    activeBottomNavTextColor = ChaiRed,
    textTitlePrimaryColor = ChaiWhite,
    textBoldColor = ChaiLightGrey,
    textNormalColor = ChaiWhite,
    textWeakColor = ChaiGrey,
    textLabelAndHeadings = ChaiTeal90,
    linkTextColorPrimary = ChaiLightGrey,
    secondaryButtonColor = ChaiTeal90,
    secondaryButtonTextColor = ChaiGrey90,
    outlinedButtonBackgroundColor = ChaiBlack,
    outlinedButtonTextColor = ChaiTeal90,
    textButtonColor = ChaiLightGrey,
    radioButtonColors = ChaiWhite,
    toggleOffBackgroundColor = ChaiLightGrey,
    toggleOffIconBackgroundColor = ChaiWhite,
    toggleOffIconColor = ChaiGrey90,
    toggleOnBackgroundColor = ChaiRed,
    toggleOnIconBackgroundColor = ChaiWhite,
    toggleOnIconColor = ChaiRed,
    loadingStateOnCardsColor = ChaiDarkGrey,
    eventDaySelectorActiveSurfaceColor = ChaiRed,
    eventDaySelectorInactiveSurfaceColor = ChaiTeal90,
    eventDaySelectorActiveTextColor = ChaiWhite,
    eventDaySelectorInactiveTextColor = ChaiWhite,
    badgeBackgroundColor = ChaiBlack,
    textFieldBackgroundColor = ChaiGrey90,
    textFieldBorderColor = ChaiSmokeyGrey,
    bottomSheetBackgroundColor = ChaiBlack,
    inactiveMultiSelectButtonBorderColor = ChaiGrey
)