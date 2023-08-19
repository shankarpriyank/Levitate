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
import androidx.compose.runtime.remember
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
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.Purple

// Todo handle state, and clicks
@OptIn(ExperimentalTextApi::class)
@Composable
fun EnterNameScreen(navHostController: NavHostController) {
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
                text = "My First Name is",
                fontFamily = Lato,
                fontSize = 24.sp,
                fontWeight = FontWeight(400),
            )
            // Todo move to viewModel
            var text = remember {
                ""
            }
            TextField(
                value = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp),
                onValueChange = {
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                ),
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                text = "This is how it will appear in Levitate, and you will and don't worry be able to change it",
                color = Color.Gray,
                fontSize = 12.sp,
            )
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(25.dp),
            onClick = {},
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

@Preview
@Composable
fun PreviewEnterNameScreen() {
    EnterNameScreen(navHostController = NavHostController(LocalContext.current))
}
