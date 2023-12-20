package com.eventhngs.feature_media_partner_menu.list

import androidx.paging.PagingData
import com.eventhngs.domain.model.EventNeedItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class MediaPartnerUiState(
    val query: String = "",
    val mediaPartners: Flow<PagingData<EventNeedItem>> = flowOf()
)
