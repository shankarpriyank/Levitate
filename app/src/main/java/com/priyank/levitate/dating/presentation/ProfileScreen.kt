package com.priyank.levitate.dating.presentation

import android.content.Context
import androidx.compose.runtime.Composable

@Composable
fun ProfileScreen() {
}
fun signout(context: Context) {
    context.getSharedPreferences("accountDetails", 0).edit().clear().commit()
}
