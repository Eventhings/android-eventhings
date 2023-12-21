package com.eventhngs.data.remote.service

import com.eventhngs.data.remote.response.AllResponse
import com.eventhngs.data.remote.response.DetailEquipmentResponse
import com.eventhngs.data.remote.response.DetailMediaPartnerResponse
import com.eventhngs.data.remote.response.DetailSponsorResponse
import com.eventhngs.data.remote.response.EquipmentResponse
import com.eventhngs.data.remote.response.ErrorResponse
import com.eventhngs.data.remote.response.LoginResponse
import com.eventhngs.data.remote.response.MediaPartnerResponse
import com.eventhngs.data.remote.response.RecomendationResponse
import com.eventhngs.data.remote.response.RefreshTokenResponse
import com.eventhngs.data.remote.response.RegisterResponse
import com.eventhngs.data.remote.response.SponsorResponse
import com.eventhngs.data.remote.response.UserResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
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

    @GET("event/sponsorship")
    suspend fun getSponsor(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0
    ): NetworkResponse<SponsorResponse, ErrorResponse>

    @GET("event/sponsorship/{id}")
    suspend fun getSponsorById(
        @Path("id") id: String
    ): NetworkResponse<DetailSponsorResponse, ErrorResponse>

    @GET("event/rentals")
    suspend fun getEquipment(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0
    ): NetworkResponse<EquipmentResponse, ErrorResponse>

    @GET("event/rentals/{id}")
    suspend fun getEquipmentById(
        @Path("id") id: String
    ): NetworkResponse<DetailEquipmentResponse, ErrorResponse>

    @GET("event/all")
    suspend fun getAll(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0
    ): NetworkResponse<AllResponse, ErrorResponse>

    @GET("ml/recommend/cf")
    suspend fun getRecommendation(
        @Header("Authorization") authorization: String
    ): NetworkResponse<RecomendationResponse, ErrorResponse>

    @GET("user/me")
    suspend fun getUserLogging(
        @Header("Authorization") authorization: String
    ): NetworkResponse<UserResponse, ErrorResponse>

    @FormUrlEncoded
    @PATCH("user/me")
    suspend fun getUpdateUser(
        @Header("Authorization") authorization: String,
        @Field("name") name: String,
        @Field("dob") birthDate: String,
        @Field("phoneNumber") phoneNumber: String,
        @Field("location") location: String,
    ): NetworkResponse<UserResponse, ErrorResponse>

    @FormUrlEncoded
    @POST("user/refresh-token")
    suspend fun refreshToken(
        @Field("refresh_token") refreshToken: String,
    ): NetworkResponse<RefreshTokenResponse, ErrorResponse>

}