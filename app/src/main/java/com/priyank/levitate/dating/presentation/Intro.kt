package com.priyank.levitate.dating.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.priyank.levitate.onboarding.domain.model.UserData

@Composable
fun UserProfileScreen(
    userDataList: List<UserData>,
    deleteUserById: (String) -> Unit,
    likeId: (String) -> Unit,
) {
    var currentIndex by remember { mutableStateOf(0) }

    LazyColumn {
        items(userDataList) { userData ->
            if (currentIndex < userDataList.size) {
                val user = userDataList[currentIndex]

                UserProfile(
                    userData = userData,
                    onLikeClick = likeId,
                    onDislikeClick = deleteUserById,

                )
            }
        }
    }
}

@Composable
fun UserProfile(
    userData: UserData,
    onLikeClick: (String) -> Unit,
    onDislikeClick: (String) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight() // Full screen
            .padding(8.dp),
        elevation = 8.dp,
    ) {
        Column(
            modifier = Modifier.padding(bottom = 56.dp),
        ) {
            // Display user image
            userData.userImagesUrl?.let { userImagesUrlList ->
                userImagesUrlList.firstOrNull()?.let { imageUrl ->
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(8.dp),
                        contentScale = ContentScale.Crop,
                    )
                }
            }

            // Display user information on the other half
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                // Display user name
                userData.username?.let { username ->
                    Text(text = "Username: $username", style = MaterialTheme.typography.h6)
                }

                // Display user bio
                userData.userBio?.let { userBio ->
                    Text(text = "Bio: $userBio", style = MaterialTheme.typography.h6)
                }

                // Display user jam
                userData.jam?.let { jam ->
                    Text(text = "Jam: $jam", style = MaterialTheme.typography.body1)
                }

                // Display user company
                userData.companyName?.let { company ->
                    Text(text = "Company: $company", style = MaterialTheme.typography.body1)
                }

                // Like and Dislike buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Button(
                        onClick = { onLikeClick(userData.userId!!) },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Like")
                    }

                    Button(
                        onClick = { onDislikeClick(userData.userId!!) },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Dislike")
                    }
                }
            }
        }
    }
}
