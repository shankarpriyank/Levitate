package com.priyank.levitate.onboarding.domain.model

import java.util.Date

data class UserData(
    val isUserVerified: Boolean = false,
    val username: String? = null,
    val userId: String? = null,
    val gender: Gender? = null,
    val userBday: Date? = null,
    val userBio: String? = null,
    val LinkedinUrl: String? = null,
    val interests: List<String>? = null,
    val jam: String? = null,
)