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

    private val _bday = MutableStateFlow("")
    val bday = _bday.asStateFlow()

    private val _companyName = MutableStateFlow("")
    val companyName = _companyName.asStateFlow()

    private var gender = ""
    fun updateName(name: String) {
        _name.value = name
    }

    fun updateBday(name: String) {
        _name.value = name
    }

    fun setGender(string: String) {
        gender = string
    }

    fun updateCompanyName(company: String) {
        _companyName.value = company
    }
}
