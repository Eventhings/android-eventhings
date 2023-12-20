package com.eventhngs.feature_home

import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.Resource

data class HomeUiState(
    val recommendations: Resource<List<EventNeedItem>> = Resource.Idle
)
