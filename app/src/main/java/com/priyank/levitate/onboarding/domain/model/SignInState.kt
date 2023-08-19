package com.priyank.levitate.onboarding.domain.model

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
)
