package com.eventhngs.feature_invoice.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eventhngs.feature_invoice.component.InvoiceHeader
import com.eventhngs.feature_invoice.component.InvoiceList
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailInvoiceScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Scaffold(
            topBar = {
                DetailTopAppBar(
                    title = "Invoice",
                    onNavigationClick = navigateUp
                )
            }
        ) {paddingValues ->

            LazyColumn(
                modifier = Modifier,
                contentPadding = paddingValues,
            ){
                item {
                    InvoiceList(
                        price = 20000.00,
                        date = "24/09/23"
                    )
                }


            }

        }
    }
}

@Preview
@Composable
fun DetailInvoicePreview() {
    EventhngsTheme {
        Surface {
            DetailInvoiceScreen()
        }
    }
    
}