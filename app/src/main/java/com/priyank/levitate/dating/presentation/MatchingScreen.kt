package com.priyank.levitate.dating.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.priyank.levitate.dating.domain.model.BottomNavItem
import com.priyank.levitate.navigation.Route
import com.priyank.levitate.navigation.SetupInnerNavGraph

@Composable
fun MatchingScreen() {
    val navControllerForBottomNav = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigationBar(
            items = listOf(
                BottomNavItem(
                    name = "Matching",
                    route = Route.InnerRoute.HOMESCREEN,
                    icon = Icons.Outlined.Home,
                ),
                BottomNavItem(
                    name = "Matches",
                    route = Route.InnerRoute.MESSAGINGSCREEN,
                    icon = Icons.Outlined.Message,
                ),
                BottomNavItem(
                    name = "Profile",
                    route = Route.InnerRoute.PROFILESCREEN,
                    icon = Icons.Outlined.Person,
                ),
            ),
            navController = navControllerForBottomNav,
            onItemClick = {
                navControllerForBottomNav.navigate(it.route)
            },
        )
    }) { padding ->

        SetupInnerNavGraph(
            modifier = Modifier.padding(padding),
            navController = navControllerForBottomNav,
            startDestination = "inner_nav_graph",
        )
    }
}
