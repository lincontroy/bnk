package com.dev.chacha.resources

data class DrawableResources(
    val vunaIcon: String = "ic_filled_star.xml",
    val vunaLogo: String = "ic_filled_star.xml",
    val filledStar: String = "ic_filled_star.xml",
    val successLogo: String = "ic_filled_star.xml",
)

val BpDrawableDarkResources = DrawableResources(
    filledStar = "ic_filled_star_dark.xml",
)
