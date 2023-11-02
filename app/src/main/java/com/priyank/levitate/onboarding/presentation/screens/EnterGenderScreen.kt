package com.priyank.levitate.onboarding.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.priyank.levitate.navigation.Route
import com.priyank.levitate.onboarding.domain.model.Gender
import com.priyank.levitate.onboarding.presentation.OnboardingScreenViewModel
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.Purple

@OptIn(ExperimentalTextApi::class)
@Composable
fun EnterGenderScreen(
    navHostController: NavHostController,
    onboardingScreenViewModel: OnboardingScreenViewModel,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp),
    ) {
        Text(
            modifier = Modifier.align(Alignment.TopStart),
            text = "Levitate",
            style = TextStyle.Default.copy(
                fontFamily = FuturaMedium,
                fontWeight = FontWeight(700),
                color = Purple,
                fontSize = 32.sp,
                drawStyle = Stroke(
                    miter = 10f,
                    width = 2f,
                    join = StrokeJoin.Round,
                ),
            ),

        )
        Text(
            text = "Back",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 10.dp),
            fontSize = 16.sp,
            fontFamily = Lato,
            fontWeight = FontWeight(400),
        )

        Column {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 140.dp, bottom = 20.dp),
                text = "I am a",
                fontFamily = Lato,
                fontSize = 24.sp,
                fontWeight = FontWeight(400),
            )

            Button(
                modifier = Modifier.widthIn(min = 120.dp),
                shape = RoundedCornerShape(25.dp),
                onClick = {
                    onboardingScreenViewModel.setGender(Gender.MALE)
                    navHostController.navigate(Route.ENTER_COMPANY)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(width = 2.dp, color = Color.Gray),
            ) {
                Text(
                    text = "Man",
                    fontSize = 24.sp,
                    fontFamily = Lato,
                    fontWeight = FontWeight(400),
                    color = Color.Gray,
                )
            }

            Button(
                modifier = Modifier
                    .widthIn(min = 120.dp)
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(25.dp),
                onClick = {
                    onboardingScreenViewModel.setGender(Gender.FEMALE)
                    navHostController.navigate(Route.ENTER_COMPANY)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(width = 2.dp, color = Color.Gray),
            ) {
                Text(
                    text = "Woman",
                    fontSize = 24.sp,
                    fontFamily = Lato,
                    fontWeight = FontWeight(400),
                    color = Color.Gray,
                )
            }
        }
    }
}
