package com.priyank.levitate.onboarding.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.priyank.levitate.onboarding.domain.model.UserData

class OnboardingDao {
    val database = Firebase.firestore

    fun addUserInfo(userData: UserData) {
        database.collection("main_users_collection").add(userData)
    }
    fun getUserInfo(userId: String) {
    }
}
