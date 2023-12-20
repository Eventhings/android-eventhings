package com.eventhngs.common.utils

fun Double.toRatingFormat(): String {
    return String.format("%.1f", this)
}