package com.eventhngs.feature_media_partner_menu.detail

import com.eventhngs.domain.model.DetailMediaPartner
import com.eventhngs.domain.model.Resource

data class DetailMediaPartnerUiState(
    val detailMediaPartner: Resource<DetailMediaPartner> = Resource.Idle
)
