package com.priyank.levitate.navigation

object Route {
    const val CONSENT = "consent"
    const val LOGIN_WITH_GMAIL = "login"
    const val ENTER_NAME = "name"
    const val ENTER_BDAY = "bday"
    const val ENTER_GENDER = "gender"
    const val ENTER_COMPANY = "company"
    const val ENTER_INTERESTS = "interests"
    const val ENTER_JAM = "jam"
    const val ENTER_BIO = "bio"
    const val ENTER_LINKDIN_URL = "lindkin"
    const val VERIFICATION_SCREEN = "verification"
    const val ADD_PHOTOS = "photos"

    object InnerRoute {
        val HOMESCREEN = "home"
        val MESSAGINGSCREEN = "message"
        val PROFILESCREEN = "profile"
    }
}
