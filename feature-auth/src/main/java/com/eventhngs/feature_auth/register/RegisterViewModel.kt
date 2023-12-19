package com.eventhngs.feature_auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.usecase.EventhngsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val eventhngsUseCase: EventhngsUseCase
) : ViewModel() {

    private val _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState: StateFlow<RegisterUiState> get() = _registerUiState

    val buttonRegisterEnabled get() = _registerUiState.map {
        it.email.isNotBlank() && it.password.length >= 6
    }

    val buttonRegisterLoading get() = _registerUiState.map {
        it.registerResult is Resource.Loading
    }

    fun updateEmail(email: String) {
        _registerUiState.update {
            it.copy(email = email)
        }
    }

    fun updatePassword(password: String) {
        _registerUiState.update {
            it.copy(password = password)
        }
    }

    fun register() {
        viewModelScope.launch {
            val email = _registerUiState.value.email
            val password = _registerUiState.value.password
            eventhngsUseCase.register(email, password).collect { result ->
                _registerUiState.update {
                    it.copy(registerResult = result)
                }
            }
        }
    }

}