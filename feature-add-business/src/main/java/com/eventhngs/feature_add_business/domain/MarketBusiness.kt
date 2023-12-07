package com.eventhngs.feature_add_business.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MarketBusiness(
    @DrawableRes
    val img: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int,
)
