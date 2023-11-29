package com.eventhngs.common.utils

import java.text.NumberFormat
import java.util.Locale

fun Double.toRupiah(): String {
    val localeID =  Locale.forLanguageTag("in-ID")
    val numberFormat = NumberFormat.getCurrencyInstance(localeID)
    return numberFormat.format(this).dropLast(3)
}
