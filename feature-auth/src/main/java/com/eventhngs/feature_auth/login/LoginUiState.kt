package com.eventhngs.feature_auth.login

import com.eventhngs.domain.model.LoginResult
import com.eventhngs.domain.model.Resource

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val loginResult: Resource<LoginResult> = Resource.Idle
)
