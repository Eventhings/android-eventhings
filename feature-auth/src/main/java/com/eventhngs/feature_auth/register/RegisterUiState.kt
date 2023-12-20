package com.eventhngs.feature_auth.register

import com.eventhngs.domain.model.RegisterResult
import com.eventhngs.domain.model.Resource

data class RegisterUiState(
    val email: String = "",
    val password: String = "",
    val registerResult: Resource<RegisterResult> = Resource.Idle
)
