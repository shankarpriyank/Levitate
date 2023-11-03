package com.priyank.levitate.dating.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.priyank.levitate.onboarding.domain.model.UserData
import kotlin.reflect.KSuspendFunction0

@Composable
fun MatchList(matches: List<UserData>, update: KSuspendFunction0<Unit>) {
    LaunchedEffect(key1 = true) {
        update()
    }
    LazyColumn {
        item {
            Text(
                text = "Chat with your matches",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(16.dp),
            )
        }
        items(matches) { match ->
            MatchItem(match = match)
        }
    }
}

@Composable
fun MatchItem(match: UserData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Circular profile picture
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray),
        ) {
            match.userImagesUrl?.firstOrNull()?.let { imageUrl ->
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Profile Picture",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Name of the match and "Start the conversation" vertically aligned
        Column {
            Text(
                text = match.username ?: "",
                style = MaterialTheme.typography.h6,
            )

            Text(
                text = "Start the conversation",
                style = MaterialTheme.typography.body2,
                color = Color.Gray,
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}
