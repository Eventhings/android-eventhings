package com.eventhngs.data

import com.eventhngs.data.mapper.toDomain
import com.eventhngs.data.remote.RemoteDataSource
import com.eventhngs.domain.model.DetailMediaPartner
import com.eventhngs.domain.model.LoginResult
import com.eventhngs.domain.model.RegisterResult
import com.eventhngs.domain.model.Resource
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
}