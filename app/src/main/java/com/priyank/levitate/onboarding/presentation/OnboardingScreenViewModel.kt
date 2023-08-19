package com.priyank.levitate.onboarding.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenViewModel @Inject constructor() : ViewModel() {
    var consentStatus = MutableStateFlow(false)
        private set

    fun updateConsentStatus(consent: Boolean) {
        consentStatus.value = consent
    }
}
