package com.priyank.levitate.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.priyank.levitate.onboarding.presentation.AddPhotosScreen
import com.priyank.levitate.onboarding.presentation.EnterBdayScreen
import com.priyank.levitate.onboarding.presentation.EnterBioScreen
import com.priyank.levitate.onboarding.presentation.EnterCompanyScreen
import com.priyank.levitate.onboarding.presentation.EnterGenderScreen
import com.priyank.levitate.onboarding.presentation.EnterInterests
import com.priyank.levitate.onboarding.presentation.EnterJam
import com.priyank.levitate.onboarding.presentation.EnterLinkdinUrlScreen
import com.priyank.levitate.onboarding.presentation.EnterNameScreen
import com.priyank.levitate.onboarding.presentation.LoginScreen
import com.priyank.levitate.onboarding.presentation.TermsAndConditionScreen
import com.priyank.levitate.onboarding.presentation.VerificationScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = Route.CONSENT) {
            TermsAndConditionScreen(navHostController = navController, onboardingScreenViewModel = hiltViewModel())
        }
        composable(route = Route.LOGIN_WITH_GMAIL) {
            LoginScreen(navHostController = navController)
        }
        composable(route = Route.ENTER_NAME) {
            EnterNameScreen(navHostController = navController)
        }
        composable(route = Route.ENTER_BDAY) {
            EnterBdayScreen(navHostController = navController)
        }
        composable(route = Route.ENTER_GENDER) {
            EnterGenderScreen(navHostController = navController)
        }
        composable(route = Route.ENTER_COMPANY) {
            EnterCompanyScreen(navHostController = navController)
        }
        composable(route = Route.ENTER_INTERESTS) {
            EnterInterests(navHostController = navController)
        }
        composable(route = Route.ENTER_JAM) {
            EnterJam(navHostController = navController)
        }
        composable(route = Route.ENTER_BIO) {
            EnterBioScreen(navHostController = navController)
        }
        composable(route = Route.ENTER_LINKDIN_URL) {
            EnterLinkdinUrlScreen(navHostController = navController)
        }
        composable(route = Route.VERIFICATION_SCREEN) {
            VerificationScreen(navHostController = navController)
        }
        composable(route = Route.ADD_PHOTOS) {
            AddPhotosScreen(navHostController = navController)
        }
    }
}
