package com.dev.chacha.loans.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.loans.presentation.apply_loan.LoanApplicationScreen
import com.dev.chacha.loans.presentation.check_loan_limit.CheckLoanLimitScreen
import com.dev.chacha.loans.presentation.ecosystem_loan.AboutEcoSystemLoanScreen
import com.dev.chacha.loans.presentation.ecosystem_loan.EcoSystemLoanScreen
import com.dev.chacha.loans.presentation.installment_loan.AboutInstallmentLoanScreen
import com.dev.chacha.loans.presentation.installment_loan.InstallmentLoanScreen
import com.dev.chacha.loans.presentation.loan_list.GetLoanListScreen
import com.dev.chacha.loans.presentation.one_month_loan.AboutOneMonthLoanScreen
import com.dev.chacha.loans.presentation.one_month_loan.OneMonthLoanScreen
import com.dev.chacha.loans.presentation.pension_loan.AboutPensionLoanScreen
import com.dev.chacha.loans.presentation.pension_loan.PensionLoanScreen
import com.dev.chacha.loans.presentation.salary_advance.AboutSalaryAdvanceLoanScreen
import com.dev.chacha.loans.presentation.salary_advance.SalaryAdvanceLoanScreen
import com.dev.chacha.util.Graph.BORROW_SCREEN_ROUTE

fun NavGraphBuilder.borrowNavGraph(navController: NavHostController) {
    composable(route = BORROW_SCREEN_ROUTE) {
        BorrowScreen(
            onNavigateToGetLoan = { navController.navigate(BorrowScreenNavigation.GetLoanListScreenNavigation.route) },
            onNavigateToPayLoan = { navController.navigate(BorrowScreenNavigation.PayLoan.route) }
        )
    }
    composable(BorrowScreenNavigation.GetLoanListScreenNavigation.route) {
        GetLoanListScreen(navController)
    }
    composable(route = BorrowScreenNavigation.GetLoan.route) {
        GetLoanScreen(
            onNavigateToCheckLoanLimit = { navController.navigate(BorrowScreenNavigation.CheckLoanLimit.route) },
            onNavigateToApplyLoan = { navController.navigate(BorrowScreenNavigation.ApplyLoan.route )}

        )
    }
    composable(BorrowScreenNavigation.CheckLoanLimit.route) {
        CheckLoanLimitScreen()
    }
    composable(route = BorrowScreenNavigation.PayLoan.route) {
        PayLoanScreen(
            onPayLoan = { navController.popBackStack(
                    route = BorrowScreenNavigation.CheckLoanLimit.route,
                    inclusive = false
                )
            }
        )
    }
    composable(BorrowScreenNavigation.ApplyLoan.route) {
        LoanApplicationScreen()
    }

    composable(BorrowScreenNavigation.AboutOneMonthLoan.route){
        AboutOneMonthLoanScreen()
    }

    composable(BorrowScreenNavigation.OneMonthLoan.route){
        OneMonthLoanScreen()
    }
    composable(BorrowScreenNavigation.AboutInstallmentLoan.route){
        AboutInstallmentLoanScreen()
    }

    composable(BorrowScreenNavigation.InstallmentLoan.route){
        InstallmentLoanScreen()
    }

    composable(BorrowScreenNavigation.AboutSalaryAdvanceLoan.route){
        AboutSalaryAdvanceLoanScreen()
    }

    composable(BorrowScreenNavigation.SalaryAdvanceLoan.route){
        SalaryAdvanceLoanScreen()
    }

    composable(BorrowScreenNavigation.AboutPensionLoan.route){
        AboutPensionLoanScreen()
    }
    composable(BorrowScreenNavigation.PensionLoan.route){
        PensionLoanScreen()
    }
    composable(BorrowScreenNavigation.AboutEcoSystemLoan.route){
        AboutEcoSystemLoanScreen()
    }
    composable(BorrowScreenNavigation.EcoSystemLoan.route){
        EcoSystemLoanScreen()
    }



}


sealed class BorrowScreenNavigation(val route: String){

    object GetLoanListScreenNavigation : BorrowScreenNavigation("landing_loan")
    object GetLoan : BorrowScreenNavigation(route = "get_loan")
    object PayLoan : BorrowScreenNavigation(route = "pay_loan")
    object CheckLoanLimit : BorrowScreenNavigation(route = "Check_loan")

    object ApplyLoan : BorrowScreenNavigation("apply_loan")
    object AboutOneMonthLoan: BorrowScreenNavigation(route= "about_call_Deposit")
    object OneMonthLoan: BorrowScreenNavigation( route = "call_Deposit")
    object AboutInstallmentLoan: BorrowScreenNavigation(route = "about_classic_savings")
    object InstallmentLoan: BorrowScreenNavigation(route = "classic_savings")
    object AboutSalaryAdvanceLoan: BorrowScreenNavigation(route = "about_fixed_deposit")
    object SalaryAdvanceLoan: BorrowScreenNavigation(route = "fixed_deposit")
    object AboutPensionLoan: BorrowScreenNavigation(route = "about_goal_Savings")
    object PensionLoan: BorrowScreenNavigation(route = "goal_savings")
    object AboutEcoSystemLoan: BorrowScreenNavigation(route = "goal_savings")
    object EcoSystemLoan: BorrowScreenNavigation(route = "goal_savings")
}
