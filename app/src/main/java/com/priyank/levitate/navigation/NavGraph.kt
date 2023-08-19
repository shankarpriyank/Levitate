package com.priyank.levitate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.priyank.levitate.onboarding.presentation.OnboardingScreenViewModel
import com.priyank.levitate.onboarding.presentation.screens.AddPhotosScreen
import com.priyank.levitate.onboarding.presentation.screens.EnterBdayScreen
import com.priyank.levitate.onboarding.presentation.screens.EnterBioScreen
import com.priyank.levitate.onboarding.presentation.screens.EnterCompanyScreen
import com.priyank.levitate.onboarding.presentation.screens.EnterGenderScreen
import com.priyank.levitate.onboarding.presentation.screens.EnterInterests
import com.priyank.levitate.onboarding.presentation.screens.EnterJam
import com.priyank.levitate.onboarding.presentation.screens.EnterLinkdinUrlScreen
import com.priyank.levitate.onboarding.presentation.screens.EnterNameScreen
import com.priyank.levitate.onboarding.presentation.screens.LoginScreen
import com.priyank.levitate.onboarding.presentation.screens.TermsAndConditionScreen
import com.priyank.levitate.onboarding.presentation.screens.VerificationScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation(startDestination = Route.CONSENT, route = "onboarding_nav_graph") {
            composable(route = Route.CONSENT) { entry ->
                TermsAndConditionScreen(
                    navHostController = navController,
                    onboardingScreenViewModel = entry.sharedViewModel<OnboardingScreenViewModel>(
                        navController = navController,
                    ),
                )
            }
            composable(route = Route.LOGIN_WITH_GMAIL) { entry ->
                LoginScreen(
                    navHostController = navController,
                    onboardingScreenViewModel = entry.sharedViewModel<OnboardingScreenViewModel>(
                        navController = navController,
                    ),
                )
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
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}
