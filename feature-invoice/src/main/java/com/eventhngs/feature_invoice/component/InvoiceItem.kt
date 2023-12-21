package com.eventhngs.feature_invoice.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.common.utils.toRupiah
import com.eventhngs.feature_invoice.domain.Invoice
import com.eventhngs.feature_invoice.domain.InvoiceDetail
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.blue1
import com.eventhngs.ui.theme.poppinsFontFamily


@Composable
fun InvoiceItem(invoice: Invoice) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(invoice.items) { item ->
                InvoiceItemRow(item = item)
            }
        }

        Text(
            text = "Total: ${calculateTotal(invoice.items)}",
            style = androidx.compose.material.MaterialTheme.typography.h6,
            modifier = Modifier
                .align(Alignment.End)
                .padding(vertical = 16.dp)
        )
    }
}

@Composable
fun InvoiceItemRow(item: InvoiceDetail) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item.name)
        Text(text = "${item.quantity} x ${item.price.toRupiah()}")
    }
}

fun calculateTotal(items: List<InvoiceDetail>): Double {
    var total = 0.0
    for (item in items) {
        total += item.quantity * item.price
    }
    return total
}


@Preview
@Composable
fun PreviewInvoice() {
    EventhngsTheme {
        Surface {
            val sampleInvoice = Invoice(
                number = "INV-001",
                items = listOf(
                    InvoiceDetail("Item A", 2, 25.0),
                    InvoiceDetail("Item B", 1, 15.0),
                    InvoiceDetail("Item C", 3, 10.0)
                )
            )
            InvoiceItem(invoice = sampleInvoice)
        }
    }
}