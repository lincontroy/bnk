package com.dev.chacha.home.presentation.home_screen

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.StandardCard

@Composable
fun ShimmerListItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if(isLoading) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            StandardCard(
            ) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(30.dp)
                                .shimmerEffect()
                        )
                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(30.dp)
                                .shimmerEffect()
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(30.dp)
                                .shimmerEffect()
                        )
                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(30.dp)
                                .shimmerEffect()
                        )
                    }

                }
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(30.dp)
                        .shimmerEffect()
                )
            }


            StandardCard(
            ) {
                Row {
                    Column {
                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(30.dp)
                                .shimmerEffect()
                        )
                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(30.dp)
                                .shimmerEffect()
                        )
                    }

                }
            }


        }


    } else {
        contentAfterLoading()
    }
}

fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        )
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}