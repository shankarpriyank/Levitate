package com.priyank.levitate.onboarding.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
import kotlin.math.min

@OptIn(ExperimentalTextApi::class, ExperimentalFoundationApi::class)
@Composable
fun EnterInterests(
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
                text = "My Interests are",
                fontFamily = Lato,
                fontSize = 24.sp,
                fontWeight = FontWeight(400),
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                text = "Let people who what do you like",
                color = Color.Gray,
                fontSize = 12.sp,
            )

            val items = onboardingScreenViewModel.interests.collectAsState().value
            LazyVerticalStaggeredGrid(
                modifier = Modifier.padding(top = 32.dp, bottom = 32.dp),
                columns = StaggeredGridCells.Adaptive(minSize = 100.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                items(items) {
                    Button(
                        modifier = Modifier
                            .widthIn(min = 40.dp)
                            .heightIn(min = 20.dp),
                        shape = RoundedCornerShape(25.dp),
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                        border = BorderStroke(width = 2.dp, color = Color.Gray),
                    ) {
                        Text(
                            text = "Woman",
                            fontSize = 14.sp,
                            fontFamily = Lato,
                            fontWeight = FontWeight(500),
                            color = Color.Gray,
                        )
                    }
                }
            }
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(25.dp),
            onClick = { navHostController.navigate(Route.ENTER_JAM) },
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
