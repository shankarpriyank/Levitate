package com.priyank.levitate.onboarding.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.priyank.levitate.onboarding.presentation.OnboardingScreenViewModel
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.Purple

// Todo figure out how to add get the list of songs, and how to store them
@OptIn(ExperimentalTextApi::class)
@Composable
fun EnterJam(
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
                    .padding(top = 140.dp),
                text = "Role??",
                fontFamily = Lato,
                fontSize = 24.sp,
                fontWeight = FontWeight(400),
            )
            TextField(
                placeholder = { Text(text = "Something Magical") },
                value = onboardingScreenViewModel.jam.collectAsState().value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp),
                onValueChange = {
                    onboardingScreenViewModel.updatejam(it)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Purple,
                    cursorColor = Purple,
                ),
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                text = "Let people know what is your expertise, are you frontend geek or a EM or you love scaling systems",
                color = Color.Gray,
                fontSize = 12.sp,
            )
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(25.dp),
            onClick = { navHostController.navigate(Route.ENTER_LINKDIN_URL) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple),
        ) {
            Text(
                text = "Continue",
                fontSize = 24.sp,
                fontFamily = Lato,
                fontWeight = FontWeight(400),
                color = Color.White,
            )
        }
    }
}
