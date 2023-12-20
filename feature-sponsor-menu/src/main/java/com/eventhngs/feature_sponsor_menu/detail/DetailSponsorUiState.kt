package com.eventhngs.feature_sponsor_menu.detail

import com.eventhngs.domain.model.DetailSponsor
import com.eventhngs.domain.model.Resource

data class DetailSponsorUiState(
    val detailSponsor: Resource<DetailSponsor> = Resource.Idle
)
