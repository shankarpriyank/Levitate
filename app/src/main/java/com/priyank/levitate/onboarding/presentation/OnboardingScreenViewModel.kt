package com.priyank.levitate.onboarding.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenViewModel @Inject constructor() : ViewModel() {
    var consentStatus = mutableStateOf(false)
        private set

    fun updateConsentStatus(consent: Boolean) {
        consentStatus.value = consent
    }
}
