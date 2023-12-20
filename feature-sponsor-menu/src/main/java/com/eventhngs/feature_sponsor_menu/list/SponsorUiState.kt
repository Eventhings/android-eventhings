package com.eventhngs.feature_sponsor_menu.list

import androidx.paging.PagingData
import com.eventhngs.domain.model.EventNeedItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class SponsorUiState(
    val query: String = "",
    val sponsors: Flow<PagingData<EventNeedItem>> = flowOf()
)
