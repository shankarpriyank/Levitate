package com.priyank.levitate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.priyank.levitate.navigation.SetupNavGraph
import com.priyank.levitate.onboarding.presentation.LoginScreenViewModel
import com.priyank.levitate.ui.theme.LevitateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LevitateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White,
                ) {
                    val navController = rememberNavController()
                    val loginScreenViewModel: LoginScreenViewModel = hiltViewModel()

                    SetupNavGraph(
                        navController = navController,
                        // TODO revert back
                        startDestination = if (!loginScreenViewModel.isUserLoggedIn()) "onboarding_nav_graph" else "login_nav_graph",
                    )
                }
            }
        }
    }
}
