package com.priyank.levitate.dating.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Intro() {
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