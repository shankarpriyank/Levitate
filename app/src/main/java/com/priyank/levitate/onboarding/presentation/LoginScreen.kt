package com.priyank.levitate.onboarding.presentation

import SignInButton
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.common.api.ApiException
import com.priyank.levitate.R
import com.priyank.levitate.onboarding.GoogleApiContract
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.Purple

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreen(navHostController: NavHostController) {
    val signInRequestCode = 1
    val authResultLauncher =
        rememberLauncherForActivityResult(contract = GoogleApiContract()) { task ->
            try {
                val gsa = task?.getResult(ApiException::class.java)

                if (gsa != null) {
                    // Success Case
                } else {
                    Log.e("Login Failed", "Error")
                }
            } catch (e: ApiException) {
                Log.e("Error in AuthScreen%s", e.toString())
            }
        }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column {
                Text(
                    modifier = Modifier,
                    text = "It’s time to",
                    fontSize = 20.sp,
                    fontFamily = Lato,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Start,

                )
                Text(
                    text = "Levitate",
                    fontSize = 48.sp,
                    fontFamily = FuturaMedium,
                    fontWeight = FontWeight(700),
                    color = Purple,
                )
            }
        }
        SignInButton(
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth().padding(32.dp),
            text = "Continue in with Google",
            loadingText = "Signing in...",
            isLoading = false,
            icon = painterResource(id = R.drawable.ic_google_logo),
            onClick = { authResultLauncher.launch(signInRequestCode) },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navHostController = NavHostController(LocalContext.current))
}
