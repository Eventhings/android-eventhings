package com.eventhngs.feature_auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.usecase.EventhngsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val eventhngsUseCase: EventhngsUseCase
) : ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> get() = _loginUiState

    val buttonLoginEnabled get() = _loginUiState.map {
        it.email.isNotBlank() && it.password.length >= 6
    }

    val buttonLoginLoading get() = _loginUiState.map {
        it.loginResult is Resource.Loading
    }

    fun updateEmail(email: String) {
        _loginUiState.update {
            it.copy(email = email)
        }
    }

    fun updatePassword(password: String) {
        _loginUiState.update {
            it.copy(password = password)
        }
    }

    fun login() {
        viewModelScope.launch {
            val email = _loginUiState.value.email
            val password = _loginUiState.value.password
            eventhngsUseCase.login(email, password).collect { result ->
                _loginUiState.update {
                    it.copy(loginResult = result)
                }
            }
        }
    }

}