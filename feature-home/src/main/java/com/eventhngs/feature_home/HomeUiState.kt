package com.eventhngs.feature_home

import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.model.UserPreference

data class HomeUiState(
    val userPreference: UserPreference = UserPreference(),
    val recommendations: Resource<List<EventNeedItem>> = Resource.Idle
)
