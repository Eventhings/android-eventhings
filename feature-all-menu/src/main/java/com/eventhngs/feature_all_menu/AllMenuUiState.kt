package com.eventhngs.feature_all_menu

import androidx.paging.PagingData
import com.eventhngs.domain.model.EventNeedItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class AllMenuUiState(
    val query: String = "",
    val allMenus: Flow<PagingData<EventNeedItem>> = flowOf()
)
