package com.priyank.levitate.onboarding.presentation.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import coil.compose.AsyncImage
import com.priyank.levitate.R
import com.priyank.levitate.navigation.Route
import com.priyank.levitate.onboarding.presentation.OnboardingScreenViewModel
import com.priyank.levitate.ui.theme.FuturaMedium
import com.priyank.levitate.ui.theme.Lato
import com.priyank.levitate.ui.theme.Purple

@OptIn(ExperimentalTextApi::class)
@Composable
fun AddPhotosScreen(navHostController: NavHostController, onboardingScreenViewModel: OnboardingScreenViewModel) {
    var selectedImageUri1 by remember { mutableStateOf<Uri?>(null) }
    var selectedImageUri2 by remember { mutableStateOf<Uri?>(null) }
    var selectedImageUri3 by remember { mutableStateOf<Uri?>(null) }
    var selectedImageUri4 by remember { mutableStateOf<Uri?>(null) }
    // Create a list of selectedImageUris
    var selectedImageUris =
        listOf(selectedImageUri1, selectedImageUri2, selectedImageUri3, selectedImageUri4)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp),
        contentAlignment = Alignment.Center,
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

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                modifier = Modifier.padding(top = 40.dp),
                text = "Add Photo",
                fontFamily = Lato,
                fontSize = 24.sp,
                fontWeight = FontWeight(400),
            )

            var clickedIndex by remember { mutableStateOf<Int?>(null) }

            val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.PickVisualMedia(),
                onResult = { uri ->
                    // Update the selectedImageUri for the clicked index
                    clickedIndex?.let { index ->
                        when (index) {
                            0 -> selectedImageUri1 = uri
                            1 -> selectedImageUri2 = uri
                            2 -> selectedImageUri3 = uri
                            3 -> selectedImageUri4 = uri
                        }
                    }
                },
            )

// Use LazyVerticalGrid to display images in two rows
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    items(4) { index ->
                        val selectedUri: Uri? = selectedImageUris[index]
                        AsyncImage(
                            modifier = Modifier
                                .size(160.dp)
                                .clickable {
                                    // Set the clicked index
                                    clickedIndex = index

                                    singlePhotoPickerLauncher.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly),
                                    )
                                },
                            model = selectedUri ?: R.drawable.plus,
                            contentDescription = null,
                        )
                    }
                },
            )
        }

        Button(
            modifier = Modifier.align(Alignment.BottomEnd),
            shape = RoundedCornerShape(25.dp),
            onClick = {
                updatePhotoAndNavigate(navHostController, onboardingScreenViewModel, selectedImageUris)
            },
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

fun updatePhotoAndNavigate(
    navHostController: NavHostController,
    onboardingScreenViewModel: OnboardingScreenViewModel,
    list: List<Uri?>,
) {
    onboardingScreenViewModel.updateImages(list)

    navHostController.navigate(Route.ENTER_LINKDIN_URL)
}
