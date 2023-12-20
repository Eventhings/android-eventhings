package com.eventhngs.data.remote.service

import com.eventhngs.data.remote.response.DetailMediaPartnerResponse
import com.eventhngs.data.remote.response.ErrorResponse
import com.eventhngs.data.remote.response.LoginResponse
import com.eventhngs.data.remote.response.MediaPartnerResponse
import com.eventhngs.data.remote.response.RegisterResponse
import com.eventhngs.data.remote.response.SponsorResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET("event/media-partner")
    suspend fun getMediaPartner(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0
    ): NetworkResponse<MediaPartnerResponse, ErrorResponse>

    @GET("event/media-partner/{id}")
    suspend fun getMediaPartnerById(
        @Path("id") id: String
    ): NetworkResponse<DetailMediaPartnerResponse, ErrorResponse>

    @GET("event/sponsor")
    suspend fun getSponsor(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0
    ): NetworkResponse<SponsorResponse, ErrorResponse>

}