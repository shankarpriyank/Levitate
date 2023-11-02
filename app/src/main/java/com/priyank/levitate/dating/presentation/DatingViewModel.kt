package com.priyank.levitate.dating.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyank.levitate.onboarding.data.OnboardingDao
import com.priyank.levitate.onboarding.data.UserDetails
import com.priyank.levitate.onboarding.domain.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatingViewModel @Inject constructor(
    val userDetails: UserDetails,
) : ViewModel() {
    var users = MutableStateFlow(mutableListOf<UserData>())
    val userToBeShown = MutableStateFlow<UserData?>(null)
    val currentUserIndex = mutableStateOf(0)

    suspend fun getUserList() {
        users.value = OnboardingDao().getAllUsers().toMutableList()
    }

    init {

        viewModelScope.launch {
            getUserList()
        }
    }

    fun deleteUserById(userIdToDelete: String) {
        users.value = users.value.filterNot { it.userId == userIdToDelete }.toMutableList()
    }

    fun likeId(from: String, to: String) {}

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
