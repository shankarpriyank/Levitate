package com.priyank.levitate.onboarding.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.priyank.levitate.onboarding.domain.model.UserData

class OnboardingDao {
    val database = Firebase.firestore
    val user = UserData()

    fun gg() {
        database.collection("gg").add(user)
    }
}
