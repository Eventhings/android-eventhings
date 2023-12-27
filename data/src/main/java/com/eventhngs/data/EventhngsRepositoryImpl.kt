package com.eventhngs.data

import com.eventhngs.data.mapper.toDomain
import com.eventhngs.data.mapper.toEventNeeds
import com.eventhngs.data.remote.RemoteDataSource
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
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class EventhngsRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : EventhngsRepository {

    override fun login(email: String, password: String): Flow<Resource<LoginResult>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.login(email, password)) {
            is NetworkResponse.Success -> {
                val result = response.body.toDomain()
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override fun register(email: String, password: String): Flow<Resource<RegisterResult>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.register(email, password)) {
            is NetworkResponse.Success -> {
                val result = response.body.toDomain()
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override fun getMediaPartnerById(id: String): Flow<Resource<DetailMediaPartner>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.getMediaPartnerById(id)) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override fun getSponsorById(id: String): Flow<Resource<DetailSponsor>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.getSponsorById(id)) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override fun getEquipmentById(id: String): Flow<Resource<DetailEquipment>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.getEquipmentById(id)) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override fun getRecommendation(accessToken: String): Flow<Resource<List<EventNeedItem>>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.getRecommendation(accessToken)) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toEventNeeds()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override fun getRecommendationMediaPartner(
        accessToken: String,
        id: String
    ): Flow<Resource<List<EventNeedItem>>> = flow {

    }

    override fun getRecommendationSponsor(
        accessToken: String,
        id: String
    ): Flow<Resource<List<EventNeedItem>>> = flow{

    }

    override fun getRecommendationEquipment(
        accessToken: String,
        id: String
    ): Flow<Resource<List<EventNeedItem>>> = flow {

    }

    override fun getUserLogging(authorization: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.getUserLogging(authorization)) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override fun updateUser(
        authorization: String,
        name: String,
        birthDate: String,
        phoneNumber: String,
        domicile: String
    ): Flow<Resource<User>> = flow {
        emit(Resource.Loading)
        val response = remoteDataSource.updateUser(authorization, name, birthDate, phoneNumber, domicile)
        when (response) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }

    override fun refreshToken(refreshToken: String): Flow<Resource<RefreshToken>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.refreshToken(refreshToken)) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }
}