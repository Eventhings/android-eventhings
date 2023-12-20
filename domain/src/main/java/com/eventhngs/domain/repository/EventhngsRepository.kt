package com.eventhngs.domain.repository

import com.eventhngs.domain.model.DetailMediaPartner
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

}
