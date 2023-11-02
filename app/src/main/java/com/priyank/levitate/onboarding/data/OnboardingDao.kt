package com.priyank.levitate.onboarding.data

import android.net.Uri
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.priyank.levitate.onboarding.domain.model.Gender
import com.google.firebase.storage.ktx.storage
import com.priyank.levitate.onboarding.domain.model.UserData
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

data class UserMatches(val matches:MutableList<String>){
    constructor():this(mutableListOf())
}
class OnboardingDao {
    val database = Firebase.firestore
    val mainUserCollection = database.collection("main_users_collection")
    val userMatchesCollection = database.collection("user_matches")


    fun addUserInfo(userData: UserData) {
        mainUserCollection.document(userData.userId.toString()).set(userData).addOnSuccessListener {
            Log.e("Upload", "ggg $userData")
        }
        userMatchesCollection.document(userData.userId.toString()).set(UserMatches(mutableListOf())).addOnSuccessListener {
            Log.e("Upload", "fff $userData")
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

    suspend fun getAllFemales(): List<UserData> {
        try{
            var users:List<UserData>
            val usersDocRef = mainUserCollection.whereEqualTo("gender",Gender.FEMALE)
            users=usersDocRef.get().await().toObjects(UserData::class.java)
            Log.i("TAG", "getAllFemales: $users")
            return users

        }catch (e:Exception){
            Log.e("Gadbad", "getAllMales: $e")
            throw e
        }


    }
    suspend fun getAllMales(): List<UserData> {
        try{
            var users:List<UserData>
            val usersDocRef = mainUserCollection.whereEqualTo("gender",Gender.MALE)
            users=usersDocRef.get().await().toObjects(UserData::class.java)
            Log.i("TAG", "getAllMales: $users")
            return users

        }catch (e:Exception){
            Log.e("Gadbad", "getAllMales: $e")
            throw e
        }


    }

    suspend fun uploadImage(image: Uri): String = suspendCoroutine { continuation ->
        if (image != null) {
            val storageRef = Firebase.storage.reference
            val photoref = storageRef.child("levitate/${System.currentTimeMillis()}-photo.jpg")

            photoref.putFile(image)
                .continueWithTask { photoUploadTask ->
                    photoref.downloadUrl
                }
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val url = task.result?.toString() ?: "Error obtaining URL"
                        continuation.resume(url)
                    } else {
                        continuation.resume("Error uploading image")
                    }
                }
        } else {
            continuation.resume("Invalid image URI")
        }
    }
}
