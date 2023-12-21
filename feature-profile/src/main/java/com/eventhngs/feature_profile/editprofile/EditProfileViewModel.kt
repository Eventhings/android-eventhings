package com.eventhngs.feature_profile.editprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.usecase.EventhngsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EditProfileViewModel(
    private val eventhngsUseCase: EventhngsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(EditProfileUiState())
    val uiState: StateFlow<EditProfileUiState> get() = _uiState

    val buttonEnabled get() = _uiState.map {
        it.fullName.isNotEmpty() && it.birthDate.isNotEmpty() && it.whatsapp.isNotEmpty() &&
        it.domicile.isNotEmpty() && it.user is Resource.Success
    }

    val buttonLoading get() = _uiState.map {
        it.updateUserResult is Resource.Loading
    }

    fun updateFullName(fullName: String) {
        _uiState.update {
            it.copy(fullName = fullName)
        }
    }

    fun updateEmail(email: String) {
        _uiState.update {
            it.copy(email = email)
        }
    }

    fun updateBirthDate(birthDate: String) {
        _uiState.update {
            it.copy(birthDate = birthDate)
        }
    }

    fun updateWhatsapp(whatsapp: String) {
        _uiState.update {
            it.copy(whatsapp = whatsapp)
        }
    }

    fun updateDomicile(domicile: String) {
        _uiState.update {
            it.copy(domicile = domicile)
        }
    }

    fun getUserLogging(accessToken: String) {
        viewModelScope.launch {
            eventhngsUseCase.getUserLogging(accessToken).collect { result ->
                _uiState.update {
                    it.copy(user = result)
                }
            }
        }
    }

    fun updateUser(
        authorization: String,
        name: String,
        birthDate: String,
        phoneNumber: String,
        domicile: String,
    ) {
        viewModelScope.launch {
            eventhngsUseCase.updateUser(
                authorization, name, birthDate, phoneNumber, domicile
            ).collect { result ->
                _uiState.update {
                    it.copy(updateUserResult = result)
                }
            }
        }
    }

}