package com.eventhngs.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.eventhngs.data.paging.MediaPartnerPagingSource
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
}