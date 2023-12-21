package com.eventhngs.feature_invoice.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun InvoiceHeader(
    modifier: Modifier = Modifier,
    orderId: String,
    price: Double = 0.0
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        InvoiceItem("Order ID:", orderId)
        InvoiceItem("Grand Total:","Order Paid")

    }
}

@Composable
fun InvoiceList(
    price: Double = 0.0,
    date: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        InvoiceList(
            date = date
        )

    }

}

@Composable
fun InvoiceItem(title: String, value: String, price: Double = 0.0) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1
        )
        Text(
            text = value,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = " ",
            style = MaterialTheme.typography.body2
        )

    }
}

@Preview
@Composable
fun PreviewInvoiceScreen() {
    EventhngsTheme {
        Surface {
            InvoiceHeader(
                modifier = Modifier.fillMaxSize(),
                orderId = "230905GW7G8FFK"
            )
            InvoiceList(
                price = 20000.00,
                date = "22/09/23"
            )
        }
    }
}