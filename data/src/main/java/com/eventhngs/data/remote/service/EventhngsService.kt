package com.eventhngs.data.remote.service

import com.eventhngs.data.remote.response.ErrorResponse
import com.eventhngs.data.remote.response.LoginResponse
import com.eventhngs.data.remote.response.RegisterResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EventhngsService {

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): NetworkResponse<LoginResponse, ErrorResponse>

    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("email") email: String,
        @Field("password") password: String
    ): NetworkResponse<RegisterResponse, ErrorResponse>

}