package com.priyank.levitate.onboarding.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenViewModel @Inject constructor() : ViewModel() {

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    fun updateName(name: String) {
        _name.value = name
    }
}
