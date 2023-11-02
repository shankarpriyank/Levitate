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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.priyank.levitate.navigation.Route
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.Purple

@OptIn(ExperimentalTextApi::class)
@Composable
fun EnterBioScreen(navHostController: NavHostController) {
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
                text = "About me",
                fontFamily = Lato,
                fontSize = 24.sp,
                fontWeight = FontWeight(400),
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                text = "Write a short description about yourself.",
                color = Color.Gray,
                fontSize = 12.sp,
            )
            TextField(
                placeholder = { },
                value = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp),
                onValueChange = {
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Purple,
                    cursorColor = Purple,
                ),
            )
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(25.dp),
            onClick = { navHostController.navigate(Route.DATING) },
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

@Preview(showBackground = true)
@Composable
fun gpt() {
    EnterBioScreen(navHostController = NavHostController(LocalContext.current))
}
