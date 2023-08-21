package com.priyank.levitate.onboarding.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.priyank.levitate.data.UserDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenViewModel @Inject constructor(
    private val userDetails: UserDetails,
) : ViewModel() {
    var consentStatus = MutableStateFlow(false)
        private set

    fun updateConsentStatus(consent: Boolean) {
        consentStatus.value = consent
    }

    fun updateUserDetails(
        id: String?,
        email: String?,
        name: String?,
        profilePhotoUrl: String? = null,
    ) {
        Log.e("Email", email.toString())
        Log.e("is", id.toString())
        Log.e("name", name.toString())
        Log.e("profie", profilePhotoUrl.toString())
        userDetails.updateUser(
            id = id,
            email = email,
            name = name,
            profilePhotoUrl = profilePhotoUrl,
        )
    }
}
