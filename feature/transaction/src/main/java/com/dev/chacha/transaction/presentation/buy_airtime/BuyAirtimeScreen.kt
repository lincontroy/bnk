package com.dev.chacha.transaction.presentation.buy_airtime

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AccountTextField
import com.dev.chacha.ui.common.components.AmountCurrencyTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.PayToTextField
import com.dev.chacha.ui.common.components.PaymentReasonTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet

@SuppressLint("NewApi")
@Composable
fun BuyAirtimeScreen(
    navController: NavController
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val buyAirtimeViewModel: BuyAirtimeViewModel = viewModel()
    val buyUiState by buyAirtimeViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Buy airtime",
                showBackArrow = true,
                onNavigateBack = {navController.navigateUp()}
            )
        },
        bottomBar = {
            EquityButton(
                onClick = { /*TODO*/ },
                text = "Send Money"
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                AccountTextField(
                    value = "",
                    onValueChange = {
                        isSheetOpen = true
                        currentBottomSheet = TransactionBottomSheetType.ACCOUNT_BALANCE
                    },
                    title = "Buy from",
                    accountNumber = "12345678",
                    hint = "Available balance is 52.80"
                )

                PayToTextField(
                    value = buyUiState.mobileNumber,
                    onValueChange = {
                        isSheetOpen = true
                        currentBottomSheet = TransactionBottomSheetType.BUY_GOODS
                        buyAirtimeViewModel.onBuyAirtimeEvent(
                            BuyAirtimeUiEvent.OnMobileNumberChanged(
                                it
                            )
                        )

                    },
                    title = "Buy for",
                    hint = "Select a biller",
                    supportText = buyUiState.simOperator
                )

                AmountCurrencyTextField(
                    leftTextFieldTitleHint = "currency",
                    leftTextFieldValue = "",
                    rightTextFieldValue = "",
                    leftTextFieldPlaceholderHint = "KES",
                    rightTextFieldPlaceholderHint = stringResource(R.string.enter_amount),
                    onLeftValueChange = {
                        isSheetOpen = true
                        currentBottomSheet = TransactionBottomSheetType.CURRENCY_BOTTOM_SHEET
                    },
                    onRightValueChange = {}
                )
                PaymentReasonTextField(
                    value = "",
                    onValueChange = {},
                    title = stringResource(R.string.payment_reason),
                    hint = stringResource(R.string.optional)
                )

            }

            if (isSheetOpen) {
                EquityModalSheet(
                    onDismissRequest = {
                        isSheetOpen = false
                    },
                ) {
                    currentBottomSheet?.let {
                        EquityModalSheetLayout(
                            bottomSheetType = it,
                            onClose = {}
                        )
                    }
                }
            }


        }

    }



}