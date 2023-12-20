package com.eventhngs.domain.interactor

import androidx.paging.PagingData
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.repository.EventhngsPagingRepository
import com.eventhngs.domain.usecase.EventhngsPagingUseCase
import kotlinx.coroutines.flow.Flow

class EventhngsPagingInteractor(
    private val repository: EventhngsPagingRepository
) : EventhngsPagingUseCase {

    override fun getMediaPartner(): Flow<PagingData<EventNeedItem>> {
        return repository.getMediaPartner()
    }

    override fun getSponsor(): Flow<PagingData<EventNeedItem>> {
        return repository.getSponsor()
    }
}