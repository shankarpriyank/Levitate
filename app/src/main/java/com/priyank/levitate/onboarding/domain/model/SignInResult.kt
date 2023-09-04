package com.priyank.levitate.onboarding.domain.model

data class SignInResult(
    val data: SigninUserData?,
    val errorMessage: String?,
)

data class SigninUserData(
    val userId: String,
    val username: String?,
    val email: String?,
    val profilePictureUrl: String?,
)
