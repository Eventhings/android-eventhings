package com.eventhngs.data.remote

import com.eventhngs.data.remote.response.DetailMediaPartnerResponse
import com.eventhngs.data.remote.response.DetailSponsorResponse
import com.eventhngs.data.remote.response.ErrorResponse
import com.eventhngs.data.remote.response.LoginResponse
import com.eventhngs.data.remote.response.MediaPartnerResponse
import com.eventhngs.data.remote.response.RegisterResponse
import com.eventhngs.data.remote.response.SponsorResponse
import com.eventhngs.data.remote.service.EventhngsService
import com.haroldadmin.cnradapter.NetworkResponse

class RemoteDataSource(private val service: EventhngsService) {

    suspend fun login(
        email: String,
        password: String
    ): NetworkResponse<LoginResponse, ErrorResponse> {
        return service.login(email, password)
    }

    suspend fun register(
        email: String,
        password: String
    ): NetworkResponse<RegisterResponse, ErrorResponse> {
        return service.register(email, password)
    }

    suspend fun getMediaPartner(
        limit: Int = 10,
        page: Int = 0
    ): NetworkResponse<MediaPartnerResponse, ErrorResponse> {
        return service.getMediaPartner(limit, page)
    }

    suspend fun getMediaPartnerById(
        id: String
    ): NetworkResponse<DetailMediaPartnerResponse, ErrorResponse> {
        return service.getMediaPartnerById(id)
    }

    suspend fun getSponsor(
        limit: Int = 10,
        page: Int = 0
    ): NetworkResponse<SponsorResponse, ErrorResponse> {
        return service.getSponsor(limit, page)
    }

    suspend fun getSponsorById(
        id: String
    ): NetworkResponse<DetailSponsorResponse, ErrorResponse> {
        return service.getSponsorById(id)
    }

}