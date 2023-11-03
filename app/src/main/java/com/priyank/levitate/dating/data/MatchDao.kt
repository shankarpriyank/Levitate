package com.priyank.levitate.dating.data

import android.util.Log
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.priyank.levitate.onboarding.data.UserMatches
import kotlinx.coroutines.tasks.await

class MatchDao {
    val database = Firebase.firestore
    val matchesCollection = database.collection("matches")
    val userMatchesCollection = database.collection("user_matches")

    suspend fun addMatch(from: String, to: String) {
        if (checkMatch(to, from)) {
            addUserMatch(from, to)
        }
        matchesCollection.add(Match(from, to)).addOnSuccessListener {
            Log.e("addMatch", "match initiated")
        }
    }

    suspend fun addUserMatch(from: String, to: String) {
        try {
            val fromUserMatches =
                userMatchesCollection.document(from).get().await().toObject<UserMatches>()
            fromUserMatches?.matches?.add(to)
            fromUserMatches?.let { userMatchesCollection.document(from).set(it) }

            val toUserMatches =
                userMatchesCollection.document(to).get().await().toObject<UserMatches>()
            toUserMatches?.matches?.add(from)
            toUserMatches?.let { userMatchesCollection.document(to).set(it) }
        } catch (e: Exception) {
            Log.e("Tag", "addUserMatch: $e")
            throw e
        }
    }

    suspend fun getUserMatches(userId: String): UserMatches? {
        val userMatches =
            userMatchesCollection.document(userId).get().await().toObject<UserMatches>()
        return userMatches
    }
    suspend fun checkMatch(from: String, to: String): Boolean {
        try {
            val match = matchesCollection.where(
                Filter.and(
                    Filter.equalTo("from", from),
                    Filter.equalTo("to", to),
                ),
            ).get().await().toObjects(Match::class.java)
            Log.i("MATCH", "checkMatch: $match")
            return match.size > 0
        } catch (e: Exception) {
            Log.e("TAG", "checkMatch: $e")
            throw e
        }
    }
}
