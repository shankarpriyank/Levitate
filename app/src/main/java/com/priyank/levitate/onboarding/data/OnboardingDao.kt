package com.priyank.levitate.onboarding.data

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.priyank.levitate.onboarding.domain.model.Gender
import com.priyank.levitate.onboarding.domain.model.UserData
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat

class OnboardingDao {
    val database = Firebase.firestore
    val mainUserCollection = database.collection("main_users_collection")

    fun addUserInfo(userData: UserData) {
        mainUserCollection.document(userData.userId.toString()).set(userData).addOnSuccessListener {
            Log.e("Upload", "ggg $userData")
        }
    }

    suspend fun getUserInfo(userId: String): UserData {
       try{
           var user:UserData?=null
           val userDocRef = mainUserCollection.document(userId)
           Log.i("TAG", "getUserInfo: $userId")
               user=userDocRef.get().await().toObject<UserData>()
           Log.i("TAG", "getUserInfo: $user")


           return user?:throw Exception("Gadbad ho gayi")

       }catch (e:Exception){
           Log.e("Gadbad", "getUserInfo: $e")
           throw e
       }


    }
}
