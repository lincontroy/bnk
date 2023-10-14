package com.dev.chacha.transaction.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.transaction.presentation.create_pin.CreatePinScreen
import com.dev.chacha.transaction.presentation.third_party.pay_pal.PayPalFirstScreenSheet
import com.dev.chacha.transaction.presentation.third_party.pay_pal.WithdrawFromPayPalSheet
import com.dev.chacha.transaction.presentation.transaction.TransactionScreen
import com.dev.chacha.util.Graph.ANOTHER_BANK_ROUTE
import com.dev.chacha.util.Graph.ANOTHER_EQUITY_ACCOUNT_ROUTE
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.BUY_GOODS_ROUTE
import com.dev.chacha.util.Graph.MOBILE_WALLET_ROUTE
import com.dev.chacha.util.Graph.OWN_EQUITY_ACCOUNT_ROUTE
import com.dev.chacha.util.Graph.PAYPAL_ROUTE
import com.dev.chacha.util.Graph.PAY_BILL_ROUTE
import com.dev.chacha.util.Graph.PAY_TO_CARD_ROUTE
import com.dev.chacha.util.Graph.SCHEDULE_PAYMENT_ROUTE
import com.dev.chacha.util.Graph.TRANSACTION_SCREEN_ROUTE
import com.dev.chacha.util.Graph.WESTERN_UNION_ROUTE
import com.dev.chacha.util.Graph.WITHDRAW_CASH_AGENT_ROUTE

fun NavGraphBuilder.transactionNavGraph(
    navController: NavHostController
) {
    composable(route = TRANSACTION_SCREEN_ROUTE) {
        TransactionScreen(
            navigateToSchedulePayment = { navController.navigate(SCHEDULE_PAYMENT_ROUTE)},
            navigateToOwnEquityAccount = { navController.navigate(OWN_EQUITY_ACCOUNT_ROUTE)},
            navigateToAnotherEquityAccount = { navController.navigate(ANOTHER_EQUITY_ACCOUNT_ROUTE)},
            navigateToPayWithCard = { navController.navigate(PAY_TO_CARD_ROUTE)},
            navigateToMobileWallet = { navController.navigate(MOBILE_WALLET_ROUTE)},
            navigateToAnotherBank = { navController.navigate(ANOTHER_BANK_ROUTE)},
            navigateToPayBill = { navController.navigate(PAY_BILL_ROUTE)},
            navigateToBuyGoods = { navController.navigate(BUY_GOODS_ROUTE)},
            navigateToBuyAirtime = { navController.navigate(BUY_AIRTIME_ROUTE)},
            navigateToWithdrawCashAgent = { navController.navigate(WITHDRAW_CASH_AGENT_ROUTE)},
            navigateToPayPal = { navController.navigate(PAYPAL_ROUTE)},
            navigateToWesternUnion = { navController.navigate(WESTERN_UNION_ROUTE)},
            navigateToCreatePin ={ navController.navigate(TransactionNavigation.CreatePin.route)}
        )
    }
    composable(TransactionNavigation.CreatePin.route){
        CreatePinScreen()
    }









}



sealed class TransactionNavigation(val route: String) {
    object CreatePin:TransactionNavigation("create_pin")
    object WithdrawFromPayPal: TransactionNavigation("withdraw_from_paypal")
    object PayPalFirstScreenSheet: TransactionNavigation("first_from_paypal")
}