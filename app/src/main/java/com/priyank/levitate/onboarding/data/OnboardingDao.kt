package com.priyank.levitate.onboarding.data

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.priyank.levitate.onboarding.domain.model.UserData
import kotlinx.coroutines.tasks.await

class OnboardingDao {
    val database = Firebase.firestore
    val mainUserCollection = database.collection("main_users_collection")

    fun addUserInfo(userData: UserData) {
        mainUserCollection.add(userData).addOnSuccessListener {
            Log.e("Upload", "ggg")
        }
    }

    suspend fun getUserInfo(userId: String): UserData {
        val user = mainUserCollection.get().await().toObjects(UserData::class.java)
        mainUserCollection.addSnapshotListener { snapshot, error ->
            if (snapshot == null || error != null) {
                Log.e("FireStore ERR", "$error")
                return@addSnapshotListener
            } else {
                val user = snapshot.toObjects(UserData::class.java)
                Log.i("Info", user.size.toString())

                Log.i("Info", user[0].toString())
            }
        }
        return user[0]
    }
}
