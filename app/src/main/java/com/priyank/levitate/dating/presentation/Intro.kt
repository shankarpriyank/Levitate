package com.priyank.levitate.dating.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.priyank.levitate.dating.data.MatchDao
import com.priyank.levitate.onboarding.data.OnboardingDao

@Composable
fun Intro() {
    LaunchedEffect(key1 = true, ){
        val od=OnboardingDao()
        od.getAllFemales()

        val md=MatchDao()
        md.addMatch(from="ZILmUaL5idUwfPvAz1MeYNNLdZB3",to="zGpmscntGbavNZi5syqGylU4peo2")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
    }
}

@Preview
@Composable
fun gg() {
    Intro()
}
