package com.dev.chacha.onboarding.onboard

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.onboarding.onboard.OnBoardScreen
import com.dev.chacha.util.Graph.AUTHENTICATION
import com.dev.chacha.util.Graph.ONBOARDING_ROUTE

fun NavGraphBuilder.onboardingNavGraph(navController: NavHostController){
    composable(ONBOARDING_ROUTE){
        OnBoardScreen(
            navController = navController,
            onClickAction = { navController.navigate(AUTHENTICATION) }
        )
    }
}