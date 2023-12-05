package com.eventhngs.data.remote

import com.eventhngs.data.remote.response.ErrorResponse
import com.eventhngs.data.remote.response.LoginResponse
import com.eventhngs.data.remote.response.RegisterResponse
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

}