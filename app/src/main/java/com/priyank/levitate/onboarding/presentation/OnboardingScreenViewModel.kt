package com.priyank.levitate.onboarding.presentation

import android.net.Uri
import android.service.autofill.UserData
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyank.levitate.onboarding.data.OnboardingDao
import com.priyank.levitate.onboarding.data.UserDetails
import com.priyank.levitate.onboarding.domain.model.Gender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenViewModel @Inject constructor(
    val userDetails: UserDetails,
) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private val _bday = MutableStateFlow("")
    val bday = _bday.asStateFlow()

    val gg = mutableListOf<String>()
    private val _interests = MutableStateFlow<List<String>>(gg)
    val interests = _interests.asStateFlow()

    private val _companyName = MutableStateFlow("")
    val companyName = _companyName.asStateFlow()

    private val _linkedInUrl = MutableStateFlow("")
    val linkedInUrl = _linkedInUrl.asStateFlow()

    private val _userBio = MutableStateFlow("")
    val userBio = _userBio.asStateFlow()

    private val _jam = MutableStateFlow("")
    val jam = _jam.asStateFlow()

    val gpt = mutableListOf<Uri?>()

    val imageUris = MutableStateFlow(gpt)
    val urls = mutableListOf<String>()

    val imageUrls = MutableStateFlow(urls)

    private var gender = Gender.MALE

    fun updateName(name: String) {
        _name.value = name
    }

    fun updateBday(name: String) {
        _bday.value = name
    }

    fun setGender(userGender: Gender) {
        gender = userGender
    }

    fun updateCompanyName(company: String) {
        _companyName.value = company
    }

    fun updateLinkdInUrl(linkedIn: String) {
        _linkedInUrl.value = linkedIn
    }

    fun updateImages(images: List<Uri?>) {
        imageUris.value = images.toMutableList()
        uploadImages()
    }

    private fun uploadImages() {
        viewModelScope.launch {
            var imageurls = mutableListOf<String>()
            delay(1000)
            imageUris.value.forEach {
                val gg = OnboardingDao().uploadImage(it!!)
                imageurls.add(gg)
            }
            imageUrls.value = imageurls
        }
    }

    fun uploadUserDetail() {
        val userDetails = com.priyank.levitate.onboarding.domain.model.UserData(
            userVerified = 0,
            username = _name.value,
            userId = userDetails.getUserId(),
            userBday = SimpleDateFormat("dd-MM-yyyy").parse(_bday.value),
            gender = gender,
            userBio = _userBio.value,
            LinkedinUrl = _linkedInUrl.value,
            interests = _interests.value,
            jam = _jam.value,
            userImagesUrl = imageUrls.value,
            companyName = _companyName.value,

        )
        OnboardingDao().addUserInfo(userDetails)
    }

    fun updatejam(jam: String) {
        _jam.value = jam
    }

    suspend fun isUserVerifiied(): Boolean {
        val user = userDetails.getUserId()?.let { OnboardingDao().getUserInfo(it) }
        Log.e("WOWOWO", user.toString())
        return user!!.userVerified == 1
    }

    fun isUserDetailsFilled(): Boolean {
        Log.e("IsDetailed", userDetails.getIsDetailsFilled().toString())
        return userDetails.getIsDetailsFilled()
    }

    fun setUserDetailsFilled() {
        userDetails.detailsFilled()
    }

    init {
        for (i in 0..100) {
            gg.add("GG $i")
        }
    }
}
