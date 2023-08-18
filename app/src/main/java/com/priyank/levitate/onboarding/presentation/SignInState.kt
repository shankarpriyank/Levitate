package com.priyank.levitate.onboarding.presentation

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
)
