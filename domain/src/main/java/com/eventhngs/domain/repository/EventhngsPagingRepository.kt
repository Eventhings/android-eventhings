package com.eventhngs.domain.repository

import androidx.paging.PagingData
import com.eventhngs.domain.model.EventNeedItem
import kotlinx.coroutines.flow.Flow

interface EventhngsPagingRepository {

    fun getMediaPartner(): Flow<PagingData<EventNeedItem>>

    fun getSponsor(): Flow<PagingData<EventNeedItem>>

    fun getEquipment(): Flow<PagingData<EventNeedItem>>

    fun getAll(): Flow<PagingData<EventNeedItem>>

}