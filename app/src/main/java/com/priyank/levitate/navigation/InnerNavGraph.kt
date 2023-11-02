package com.priyank.levitate.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.priyank.levitate.dating.presentation.DatingViewModel
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
        composable(route = Route.InnerRoute.HOMESCREEN) { entry ->
            var users = mutableListOf<UserData>()
            val vm = hiltViewModel<DatingViewModel>()
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
            Text(
                modifier = modifier,
                text = "PG",
            )
        }
        composable(route = Route.InnerRoute.PROFILESCREEN) { entry ->
            Text(
                modifier = modifier,
                text = "EG",
            )
        }
    }
}
