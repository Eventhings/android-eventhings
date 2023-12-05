package com.eventhngs.domain.usecase

import com.eventhngs.domain.model.LoginResult
import com.eventhngs.domain.model.RegisterResult
import com.eventhngs.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface EventhngsUseCase {

    fun login(
        email: String,
        password: String
    ): Flow<Resource<LoginResult>>

    fun register(
        email: String,
        password: String
    ): Flow<Resource<RegisterResult>>

}