package com.priyank.levitate.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.priyank.levitate.dating.presentation.Intro

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
            Intro()
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
