package com.dev.chacha.ui.common.segmented_control

import androidx.annotation.ColorRes
import androidx.compose.foundation.BorderStroke

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.dev.chacha.ui.R
import timber.log.Timber

@Composable
fun SegmentedControl(
    items: List<String>,
    defaultSelectedItemIndex: Int = 0,
    useFixedWidth: Boolean = false,
    itemWidth: Dp = 120.dp,
    cornerRadius : Int = 10,
    @ColorRes color : Int = R.color.teal_200,
    onItemSelection: (selectedItemIndex: Int) -> Unit
) {
    val selectedIndex = remember { mutableIntStateOf(defaultSelectedItemIndex) }

    Row(
        modifier = Modifier
    ) {
        items.forEachIndexed { index, item ->
            OutlinedButton(
                modifier = when (index) {
                    0 -> {
                        if (useFixedWidth) {
                            Modifier
                                .width(itemWidth)
                                .offset(0.dp, 0.dp)
                                .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                        } else {
                            Modifier
                                .wrapContentSize()
                                .offset(0.dp, 0.dp)
                                .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                        }
                    } else -> {
                        if (useFixedWidth)
                            Modifier
                                .width(itemWidth)
                                .offset((-1 * index).dp, 0.dp)
                                .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                        else Modifier
                            .wrapContentSize()
                            .offset((-1 * index).dp, 0.dp)
                            .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                    }
                },
                onClick = {
                    selectedIndex.intValue = index
                    onItemSelection(selectedIndex.intValue)
                },
                shape = when (index) {
                    /**
                     * left outer button
                     */
                    0 -> RoundedCornerShape(
                        topStartPercent = cornerRadius,
                        topEndPercent = 0,
                        bottomStartPercent = cornerRadius,
                        bottomEndPercent = 0
                    )
                    /**
                     * right outer button
                     */
                    items.size - 1 -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = cornerRadius,
                        bottomStartPercent = 0,
                        bottomEndPercent = cornerRadius
                    )
                    /**
                     * middle button
                     */
                    else -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = 0,
                        bottomStartPercent = 0,
                        bottomEndPercent = 0
                    )
                },
                border = BorderStroke(
                    1.dp, if (selectedIndex.intValue == index) {
                        colorResource(id = color)
                    } else {
                        colorResource(id = color).copy(alpha = 0.75f)
                    }
                ),
                colors = if (selectedIndex.intValue == index) {
                    /**
                     * selected colors
                     */
                    ButtonDefaults.outlinedButtonColors(
                        containerColor = colorResource(
                            id = color
                        )
                    )
                } else {
                    /**
                     * not selected colors
                     */
                    ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent)
                },
            ) {
                Text(
                    text = item,
                    fontWeight = FontWeight.Normal,
                    color = if (selectedIndex.intValue == index) {
                        Color.White
                    } else {
                        colorResource(id = color).copy(alpha = 0.9f)
                    },
                )
            }
        }
    }
}


@Composable
@Preview
fun SegmentedControlPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home")
                }
            )
        }) { paddingvalues ->
        Box(modifier = Modifier
            .padding(paddingvalues)
            .background(Color.White)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
                    .background(Color.White),
            ) {
                /**
                 * Wrap size
                 */
                Text(text = "Wrap size : ")
                Spacer(modifier = Modifier.height(10.dp))
                val genders = listOf("Male", "Female")
                SegmentedControl(
                    items = genders,
                    defaultSelectedItemIndex = 0
                ) {
                    Timber.tag("CustomToggle").e("Selected item : %s", genders[it])
                }

                Spacer(modifier = Modifier.height(10.dp))
                val genders4 = listOf("Male", "Female")
                SegmentedControl(
                    items = genders4,
                    defaultSelectedItemIndex = 0,
                    cornerRadius = 50,
                    color = R.color.purple_200
                ) {
                    Timber.tag("CustomToggle").e("Selected item : %s", genders4[it])
                }

                Spacer(modifier = Modifier.height(30.dp))

                /**
                 * Fixed size
                 */
                Text(text = "Fixed size : ")
                Spacer(modifier = Modifier.height(10.dp))
                val genders1 = listOf("Male", "Female")
                SegmentedControl(
                    items = genders1,
                    defaultSelectedItemIndex = 0,
                    useFixedWidth = true,
                    itemWidth = 120.dp
                ) {
                    Timber.tag("CustomToggle").e("Selected item : %s", genders1[it])
                }

                Spacer(modifier = Modifier.height(10.dp))
                val genders2 = listOf("Male", "Female")
                SegmentedControl(
                    items = genders2,
                    defaultSelectedItemIndex = 0,
                    useFixedWidth = true,
                    itemWidth = 120.dp,
                    cornerRadius = 50,
                    color = R.color.purple_200
                ) {
                    Timber.tag("CustomToggle").e("Selected item : %s", genders2[it])
                }

                Spacer(modifier = Modifier.height(30.dp))

                /**
                 * Multiple items
                 */
                Text(text = "Multiple items : ")
                Spacer(modifier = Modifier.height(10.dp))
                val items = listOf("One", "Two", "Three", "Four")
                SegmentedControl(
                    items = items,
                    defaultSelectedItemIndex = 0
                ) {
                    Timber.tag("CustomToggle").e("Selected item : %s", items[it])
                }

                Spacer(modifier = Modifier.height(10.dp))
                val items1 = listOf("One", "Two", "Three", "Four")
                SegmentedControl(
                    items = items1,
                    defaultSelectedItemIndex = 0,
                    color = R.color.purple_200,
                    cornerRadius = 50
                ) {
                    Timber.tag("CustomToggle").e("Selected item : %s", items1[it])
                }
            }
        }
    }
}
