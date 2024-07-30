package com.dev.chacha.resources.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.dev.chacha.resources.DrawableResources
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi



fun String.capitalizeFirstLetter(): String {
    return lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun painterResource(resource: DrawableResources): Painter {
    return painterResource(resource.toString())
}


fun Long.convertLongToFormattedDate(): String {
    val instant = Instant.fromEpochMilliseconds(this)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    val monthAbbreviation = localDateTime.month.name.substring(0, 3)
    val formattedDate = "${monthAbbreviation} ${localDateTime.dayOfMonth}/${localDateTime.year}"
    return formattedDate
}

