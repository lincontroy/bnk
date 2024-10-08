package com.dev.chacha.home.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.home.presentation.home_screen.components.HomeServiceCard
import com.dev.chacha.home.presentation.home_screen.components.MyAccountsCard
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItemWithCard
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import com.dev.chacha.ui.common.modal_sheet_layouts.StandardModalSheetLayout
import com.dev.chacha.ui.common.modal_sheet_layouts.TransactionBottomSheetType
import com.chachadeveloper.designsystem.theme.DefaultBackground
import com.dev.chacha.util.Graph.BORROW_SCREEN_ROUTE
import com.dev.chacha.util.Graph.SAVINGS_SCREEN_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    onClickAction: () -> Unit,
    navController: NavController
) {

    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(5000)
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackground)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                StandardToolbar(
                    title = "Home",
                    userName = "Stephen Chacha",
                    showTitleWithUsername = true,
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = DefaultBackground
                    ),
                    showNotifications = true,
                    notificationCount = 100,

                    )
            }

            item {
                HomeGreetings()
            }

            item {
                ShimmerListItem(
                    isLoading = isLoading,
                    contentAfterLoading = {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            OnBoardingHome(navController = navController)
                            HomeServiceCard(
                                onClickBorrow = { navController.navigate(BORROW_SCREEN_ROUTE) },
                                onClickSave = { navController.navigate(SAVINGS_SCREEN_ROUTE) },
                                onClickTransact = { navController.navigate(TRANSACTION_SCREEN_ROUTE) }
                            )
                            MyBalanceCard()
                            MyAccountsCard(navController)
                            Column(
                                modifier = Modifier.padding(horizontal = 16.dp)
                            ) {
                                MoreVerticalItemWithCard(
                                    drawable = R.drawable.outline_add_24,
                                    title = R.string.add_account,
                                    subtitle = R.string.add_account_description,
                                    onClick = {
                                        currentBottomSheet = TransactionBottomSheetType.PAY_PAL
                                        isSheetOpen = true
                                    },
                                )
                            }

                            MyPayPalAccounts(
                                onClick = {
                                    currentBottomSheet =
                                        TransactionBottomSheetType.WITHDRAW_FROM_PAYPAL
                                    isSheetOpen = true
                                }
                            )


                            Column(
                                modifier = Modifier.padding(horizontal = 16.dp),
                            ) {
                                MoreVerticalItemWithCard(
                                    drawable = R.drawable.paypal_large_icon,
                                    title = R.string.add_your_paypal_account,
                                    onClick = {

                                    },
                                    showColorFilter = true

                                )

                            }

                            Spacer(modifier = Modifier.height(30.dp))

                        }
                    }
                )
            }


        }

    }

    if (isSheetOpen) {
        EquityModalSheet(
            onDismissRequest = {
                isSheetOpen = false
            },
        ) {
            currentBottomSheet?.let {
                StandardModalSheetLayout(
                    bottomSheetType = it,
                    onClose = {
                        coroutineScope.launch {
                            isSheetOpen = false
                        }
                    },
                    navController = navController
                )
            }
        }
    }
}

