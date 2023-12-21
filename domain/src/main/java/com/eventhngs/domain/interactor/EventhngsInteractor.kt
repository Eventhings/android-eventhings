package com.eventhngs.domain.interactor

import com.eventhngs.domain.model.DetailEquipment
import com.eventhngs.domain.model.DetailMediaPartner
import com.eventhngs.domain.model.DetailSponsor
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.LoginResult
import com.eventhngs.domain.model.RefreshToken
import com.eventhngs.domain.model.RegisterResult
import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.model.User
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

    override fun getMediaPartnerById(id: String): Flow<Resource<DetailMediaPartner>> {
        return repository.getMediaPartnerById(id)
    }

    override fun getSponsorById(id: String): Flow<Resource<DetailSponsor>> {
        return repository.getSponsorById(id)
    }

    override fun getEquipmentById(id: String): Flow<Resource<DetailEquipment>> {
        return repository.getEquipmentById(id)
    }

    override fun getRecommendation(accessToken: String): Flow<Resource<List<EventNeedItem>>> {
        return repository.getRecommendation(accessToken)
    }

    override fun getUserLogging(authorization: String): Flow<Resource<User>> {
        return repository.getUserLogging(authorization)
    }

    override fun updateUser(
        authorization: String,
        name: String,
        birthDate: String,
        phoneNumber: String,
        domicile: String
    ): Flow<Resource<User>> {
        return repository.updateUser(authorization, name, birthDate, phoneNumber, domicile)
    }

    override fun refreshToken(refreshToken: String): Flow<Resource<RefreshToken>> {
        return repository.refreshToken(refreshToken)
    }
}