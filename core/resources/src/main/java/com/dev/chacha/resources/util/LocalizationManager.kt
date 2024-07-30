package com.dev.chacha.resources.util

import androidx.compose.ui.unit.LayoutDirection
import com.dev.chacha.resources.strings.en.English
import com.dev.chacha.resources.strings.IStringResources
import com.dev.chacha.resources.strings.ar.Arabic
import com.dev.chacha.resources.strings.sw.Swahili
import com.vunatec.resources.util.LanguageCode


object LocalizationManager {
    fun getStringResources(languageCode: LanguageCode): IStringResources {
        return when (languageCode) {
            LanguageCode.EN -> English()
            LanguageCode.SW -> Swahili()
            LanguageCode.AR -> Arabic()
        }
    }

    fun getLayoutDirection(languageCode: LanguageCode): LayoutDirection {
        return when (languageCode) {
            LanguageCode.EN -> LayoutDirection.Ltr
            LanguageCode.SW -> LayoutDirection.Ltr
            else -> LayoutDirection.Rtl
        }
    }
}
