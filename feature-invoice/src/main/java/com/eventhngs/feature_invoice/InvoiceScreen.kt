package com.eventhngs.feature_invoice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType
import com.eventhngs.feature_invoice.component.EmptyInvoiceItemContent
import com.eventhngs.ui.component.tabbar.TabBar
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun InvoiceScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    navigateToMediaPartnerDetailScreen: (Int) -> Unit = {},
    navigateToSponsorDetailScreen: (Int) -> Unit = {},
    navigateToEquipmentDetailScreen: (Int) -> Unit = {},
) {


    val onItemClick: (EventNeedItem) -> Unit = {
        when (it.type) {
            EventNeedItemType.MEDIA_PARTNER -> navigateToMediaPartnerDetailScreen(it.id.toInt())
            EventNeedItemType.SPONSOR -> navigateToSponsorDetailScreen(it.id.toInt())
            EventNeedItemType.EQUIPMENT -> navigateToEquipmentDetailScreen(it.id.toInt())
        }
    }

    val eventNeedItems = (1..10).map {
        EventNeedItem(
            id = it.toString(),
            logo = "",
            title = "Your Business Name Here",
            label = listOf("Equipment", "Sponsor", "Media Partner", "Photo Booth"),
            price = 100_000.0,
            rating = 4.0
        )
    }

    Scaffold (
        topBar = {
            DetailTopAppBar(
                title = "My Eventh!ngs",
                onNavigationClick = navigateUp
            )
        },
        modifier = modifier
    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(state = rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TabBar()
            Spacer(modifier = Modifier.height(16.dp))

            if (eventNeedItems.isEmpty()) {
                EmptyInvoiceItemContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 174.dp)
                )
            }

            eventNeedItems.forEachIndexed { index, eventNeedItem ->
                val modifierItem = if (index % 2 == 0) {
                    Modifier.padding(start = 20.dp, bottom = 8.dp)
                } else {
                    Modifier.padding(end = 20.dp, bottom = 8.dp)
                }
                com.eventhngs.feature_invoice.component.EventItem(
                    eventNeedItem = eventNeedItem,
                    onClick = onItemClick,
                    modifier = modifierItem
                )
            }
        }

    }

}

@Preview
@Composable
fun PurchasedScreenPreview() {
    EventhngsTheme {
        InvoiceScreen()
    }

}