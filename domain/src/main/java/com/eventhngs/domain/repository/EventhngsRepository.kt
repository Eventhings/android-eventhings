package com.eventhngs.domain.repository

import com.eventhngs.domain.model.DetailEquipment
import com.eventhngs.domain.model.DetailMediaPartner
import com.eventhngs.domain.model.DetailSponsor
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.LoginResult
import com.eventhngs.domain.model.RegisterResult
import com.eventhngs.domain.model.Resource
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

    fun getRecommendation(): Flow<Resource<List<EventNeedItem>>>

}
