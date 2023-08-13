package com.priyank.levitate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.LatoLightItalic
import com.priyank.levitate.ui.theme.LevitateTheme
import com.priyank.levitate.ui.theme.Purple

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LevitateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White,
                ) {
                    MovingWaveGradient()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        fontFamily = LatoLightItalic,
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LevitateTheme {
        Greeting("Android")
    }
}

@Composable
fun MovingWaveGradient() {
    Column {
        Text(
            modifier = Modifier.padding(start = 60.dp, top = 100.dp),
            text = "Welcome to,",
            fontSize = 24.sp,
            fontFamily = Lato
        )
        Text(
            modifier = Modifier.padding(start = 60.dp),
            text = "Levitate",
            fontSize = 24.sp,
            fontFamily = FuturaMedium,
            fontWeight = FontWeight(700),
            color = Purple
        )
    }


}
