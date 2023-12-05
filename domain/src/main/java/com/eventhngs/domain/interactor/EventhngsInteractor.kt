package com.eventhngs.domain.interactor

import com.eventhngs.domain.model.LoginResult
import com.eventhngs.domain.model.RegisterResult
import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.repository.EventhngsRepository
import com.eventhngs.domain.usecase.EventhngsUseCase
import kotlinx.coroutines.flow.Flow

class EventhngsInteractor(
    private val repository: EventhngsRepository
) : EventhngsUseCase {

    override fun login(email: String, password: String): Flow<Resource<LoginResult>> {
        return repository.login(email, password)
    }

    override fun register(email: String, password: String): Flow<Resource<RegisterResult>> {
        return repository.register(email, password)
    }

}