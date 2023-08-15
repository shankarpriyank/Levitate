package com.priyank.levitate.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.Purple

@Composable
fun ConsentScreen(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Text(
            modifier = Modifier.padding(start = 60.dp, top = 100.dp),
            text = "Welcome to,",
            fontSize = 24.sp,
            fontFamily = Lato,
        )
        Text(
            modifier = Modifier.padding(start = 60.dp),
            text = "Levitate",
            fontSize = 24.sp,
            fontFamily = FuturaMedium,

            fontWeight = FontWeight(700),
            color = Purple,
        )
        Text(text = "")
        Checkbox(checked = true, onCheckedChange = {})
    }
}

@Preview
@Composable
fun PreviewConsentScreen() {
    ConsentScreen(navHostController = NavHostController(LocalContext.current))
}
