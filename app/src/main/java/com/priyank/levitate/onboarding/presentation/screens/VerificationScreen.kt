package com.priyank.levitate.onboarding.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.priyank.levitate.R
import com.priyank.levitate.navigation.Route
import com.priyank.levitate.onboarding.presentation.OnboardingScreenViewModel
import com.priyank.levitate.ui.theme.Lato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun VerificationScreen(
    navHostController: NavHostController,
    onboardingScreenViewModel: OnboardingScreenViewModel,
) {
    var isUserVerified = true

    LaunchedEffect(key1 = true) {
        GlobalScope.launch(Dispatchers.Main) {
            if (onboardingScreenViewModel.isUserVerifiied()) {
                navHostController.navigate(Route.DATING)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        Text(
            modifier = Modifier
                .padding(top = 52.dp)
                .fillMaxWidth(),
            text = "Account Verification",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Lato,
        )
        Text(
            modifier = Modifier
                .padding(start = 32.dp, top = 62.dp)
                .fillMaxWidth(),
            text = "Please wait while we\n complete your\n verification",
            textAlign = TextAlign.Start,
            fontSize = 32.sp,
            fontFamily = Lato,
        )
        val composition by rememberLottieComposition(
            LottieCompositionSpec
                .RawRes(R.raw.verification),
        )
        val progress by animateLottieCompositionAsState(
            composition,

            iterations = LottieConstants.IterateForever,
            isPlaying = true,
            speed = .5f,
            ignoreSystemAnimatorScale = true,

        )
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
        )
    }
}
