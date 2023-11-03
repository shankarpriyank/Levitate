package com.priyank.levitate.dating.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyank.levitate.dating.data.MatchDao
import com.priyank.levitate.onboarding.data.OnboardingDao
import com.priyank.levitate.onboarding.data.UserDetails
import com.priyank.levitate.onboarding.data.UserMatches
import com.priyank.levitate.onboarding.domain.model.Gender
import com.priyank.levitate.onboarding.domain.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatingViewModel @Inject constructor(
    val userDetails: UserDetails,
) : ViewModel() {
    val matchDao = MatchDao()
    val onboardingDao = OnboardingDao()
    var users = MutableStateFlow(mutableListOf<UserData>())
    var matches = MutableStateFlow<UserMatches?>(UserMatches())
    var MatchesUI = MutableStateFlow(mutableListOf<UserData>())

    val userToBeShown = MutableStateFlow<UserData?>(null)
    val currentUserIndex = mutableStateOf(0)

    suspend fun getUserList(gender: Gender) {
        if (gender == Gender.MALE) {
            users.value = onboardingDao.getAllMales().toMutableList()
        } else {
            users.value = onboardingDao.getAllFemales().toMutableList()
        }
    }

    suspend fun getMatches() {
        var userdatalist = mutableListOf<UserData>()
        matches.value = userDetails.getUserId()?.let { matchDao.getUserMatches(it) }
        matches.value?.matches?.forEach {
            val user = getUserInfo(it)
            Log.e("Mera match", user.toString())
            userdatalist.add(user)
        }
        MatchesUI.value = userdatalist
    }

    suspend fun getUserInfo(userId: String): UserData {
        return onboardingDao.getUserInfo(userId)
    }

    init {

        viewModelScope.launch {
            val u = userDetails.getUserId()?.let { OnboardingDao().getUserInfo(it) }
            if (u!!.gender == Gender.MALE) {
                getUserList(Gender.FEMALE)
            } else {
                getUserList(Gender.MALE)
            }
        }
        viewModelScope.launch {
            getMatches()
        }
    }

    fun deleteUserById(userIdToDelete: String) {
        users.value = users.value.filterNot { it.userId == userIdToDelete }.toMutableList()
    }

    fun likeId(to: String) {
        viewModelScope.launch {
            matchDao.addMatch(userDetails.getUserId()!!, to)
        }
        deleteUserById(to)
        viewModelScope.launch {
            getMatches()
        }
    }

    fun showNextUser() {
        val userList = users.value
        if (userList.isNotEmpty() && currentUserIndex.value < userList.size) {
            userToBeShown.value = userList[currentUserIndex.value]
            currentUserIndex.value++
        } else {
            userToBeShown.value = null
        }
    }
}
