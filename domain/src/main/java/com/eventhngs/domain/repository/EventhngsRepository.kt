package com.eventhngs.domain.repository

import com.eventhngs.domain.model.DetailEquipment
import com.eventhngs.domain.model.DetailMediaPartner
import com.eventhngs.domain.model.DetailSponsor
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.LoginResult
import com.eventhngs.domain.model.RefreshToken
import com.eventhngs.domain.model.RegisterResult
import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.model.User
import kotlinx.coroutines.flow.Flow

interface EventhngsRepository {

    fun login(
        email: String,
        password: String
    ): Flow<Resource<LoginResult>>

    fun register(
        email: String,
        password: String
    ): Flow<Resource<RegisterResult>>

    fun getMediaPartnerById(
        id: String
    ): Flow<Resource<DetailMediaPartner>>

    fun getSponsorById(
        id: String
    ): Flow<Resource<DetailSponsor>>

    fun getEquipmentById(
        id: String
    ): Flow<Resource<DetailEquipment>>

    fun getRecommendation(accessToken: String): Flow<Resource<List<EventNeedItem>>>

    fun getRecommendationMediaPartner(accessToken: String, id: String): Flow<Resource<List<EventNeedItem>>>

    fun getRecommendationSponsor(accessToken: String, id: String): Flow<Resource<List<EventNeedItem>>>

    fun getRecommendationEquipment(accessToken: String, id: String): Flow<Resource<List<EventNeedItem>>>

    fun getUserLogging(
        authorization: String
    ): Flow<Resource<User>>

    fun updateUser(
        authorization: String,
        name: String,
        birthDate: String,
        phoneNumber: String,
        domicile: String,
    ): Flow<Resource<User>>

    fun refreshToken(
        refreshToken: String,
    ): Flow<Resource<RefreshToken>>

}
