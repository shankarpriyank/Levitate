package com.priyank.levitate.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.priyank.levitate.dating.presentation.DatingViewModel
import com.priyank.levitate.dating.presentation.MatchList
import com.priyank.levitate.dating.presentation.UserProfileScreen
import com.priyank.levitate.onboarding.data.OnboardingDao
import com.priyank.levitate.onboarding.domain.model.UserData

@Composable
fun SetupInnerNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation(startDestination = Route.InnerRoute.HOMESCREEN, route = "inner_nav_graph") {
            composable(route = Route.InnerRoute.HOMESCREEN) { entry ->
                var users = mutableListOf<UserData>()
                val vm: DatingViewModel = entry.sharedViewModel(
                    navController = navController,
                )
                LaunchedEffect(key1 = true) {
                    users = OnboardingDao().getAllUsers().toMutableList()
                }
                UserProfileScreen(
                    userDataList = vm.users.collectAsState().value,
                    deleteUserById = vm::deleteUserById,
                    likeId = vm::likeId,

                )
            }
            composable(route = Route.InnerRoute.MESSAGINGSCREEN) { entry ->
                val vm: DatingViewModel = entry.sharedViewModel(
                    navController = navController,
                )
                MatchList(matches = vm.MatchesUI.collectAsState().value, update = vm::getMatches)
            }
            composable(route = Route.InnerRoute.PROFILESCREEN) { entry ->
                Text(
                    modifier = modifier,
                    text = "EG",
                )
            }
        }
    }
}
