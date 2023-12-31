package com.eventhngs.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.eventhngs.data.paging.AllPagingSource
import com.eventhngs.data.paging.EquipmentPagingSource
import com.eventhngs.data.paging.MediaPartnerPagingSource
import com.eventhngs.data.paging.SponsorPagingSource
import com.eventhngs.data.remote.RemoteDataSource
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.repository.EventhngsPagingRepository
import kotlinx.coroutines.flow.Flow

class EventhngsPagingRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : EventhngsPagingRepository {

    override fun getMediaPartner(): Flow<PagingData<EventNeedItem>> {
        return Pager(
            config = PagingConfig(pageSize = MediaPartnerPagingSource.DEFAULT_SIZE),
            pagingSourceFactory = {
                MediaPartnerPagingSource(remoteDataSource = remoteDataSource)
            }
        ).flow
    }

    override fun getSponsor(): Flow<PagingData<EventNeedItem>> {
        return Pager(
            config = PagingConfig(pageSize = SponsorPagingSource.DEFAULT_SIZE),
            pagingSourceFactory = {
                SponsorPagingSource(remoteDataSource = remoteDataSource)
            }
        ).flow
    }

    override fun getEquipment(): Flow<PagingData<EventNeedItem>> {
        return Pager(
            config = PagingConfig(pageSize = EquipmentPagingSource.DEFAULT_SIZE),
            pagingSourceFactory = {
                EquipmentPagingSource(remoteDataSource = remoteDataSource)
            }
        ).flow
    }

    override fun getAll(): Flow<PagingData<EventNeedItem>> {
        return Pager(
            config = PagingConfig(pageSize = AllPagingSource.DEFAULT_SIZE),
            pagingSourceFactory = {
                AllPagingSource(remoteDataSource = remoteDataSource)
            }
        ).flow
    }
}