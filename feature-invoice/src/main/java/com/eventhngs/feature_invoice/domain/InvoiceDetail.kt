package com.eventhngs.feature_invoice.domain

import java.util.Date

data class InvoiceDetail(
    val name: String,
    val quantity: Int,
    val price: Double
)
data class Invoice(
    val number: String,
    val items: List<InvoiceDetail>
)

data class InvoiceList(
    val price: Double,
    val date: Date
)