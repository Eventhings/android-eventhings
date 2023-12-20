package com.eventhngs.feature_saved_item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType
import com.eventhngs.feature_saved_item.component.EmptySavedItemContent
import com.eventhngs.ui.component.event.EventNeedItem
import com.eventhngs.ui.component.searchbar.SmallSearchBar
import com.eventhngs.ui.component.topappbar.BaseTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun SavedItemScreen(
    modifier: Modifier = Modifier,
    navigateToMediaPartnerDetailScreen: (String) -> Unit = {},
    navigateToSponsorDetailScreen: (String) -> Unit = {},
    navigateToEquipmentDetailScreen: (String) -> Unit = {},
) {

    var query by remember { mutableStateOf("") }

    val onItemClick: (EventNeedItem) -> Unit = {
        when (it.type) {
            EventNeedItemType.MEDIA_PARTNER -> navigateToMediaPartnerDetailScreen(it.id)
            EventNeedItemType.SPONSOR -> navigateToSponsorDetailScreen(it.id)
            EventNeedItemType.EQUIPMENT -> navigateToEquipmentDetailScreen(it.id)
        }
    }

    val eventNeedItems = listOf(
        EventNeedItem(
            id = "1",
            logo = "https://pbs.twimg.com/profile_images/1281601097581211648/ZUwX2det_400x400.jpg",
            title = "Magang Update",
            label = listOf("Media Partner", "Career"),
            price = 100_000.0,
            rating = 4.9,
            type = EventNeedItemType.MEDIA_PARTNER
        ),
        EventNeedItem(
            id = "2",
            logo = "https://upload.wikimedia.org/wikipedia/commons/3/3b/Nutrifood.png",
            title = "Nutrifood",
            label = listOf("Equipment", "Bouquet"),
            price = 0.0,
            rating = 5.0,
            type = EventNeedItemType.EQUIPMENT
        ),
        EventNeedItem(
            id = "3",
            logo = "https://media.licdn.com/dms/image/C4E0BAQG_rgylSaTLoA/company-logo_200_200/0/1630628774592/indonesian_event_logo?e=2147483647&v=beta&t=L_gC2hWXLZQZY9wpBzsu1sg57-MLAnV7L7MYVJoqzuA",
            title = "Indonesian Event",
            label = listOf("Media Partner", "Event"),
            price = 25_000.0,
            rating = 4.9,
            type = EventNeedItemType.MEDIA_PARTNER
        ),
        EventNeedItem(
            id = "4",
            logo = "https://asset.kompas.com/crop/0x0:0x0/720x360/data/photo/2022/01/05/61d5532faf8e8.jpg",
            title = "Indosat Ooredoo Hutchison",
            label = listOf("Sponsor", "Telecommunication"),
            price = 0.0,
            rating = 5.0,
            type = EventNeedItemType.EQUIPMENT
        )
    )


    Scaffold(
        topBar = {
            BaseTopAppBar(title = "Saved")
        },
        modifier = modifier
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.navigationBarsPadding(),
            contentPadding = paddingValues
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                SmallSearchBar(
                    value = query,
                    onValueChange = { query = it },
                    placeholder = "Search",
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(16.dp))
            }
            if (eventNeedItems.isEmpty()) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    EmptySavedItemContent(
                        modifier = Modifier.fillMaxSize()
                            .padding(top = 174.dp)
                    )
                }
            }
            itemsIndexed(items = eventNeedItems, key = { _, event -> event.id }) { index, eventNeedItem ->
                val modifierItem = if (index % 2 == 0) {
                    Modifier.padding(start = 20.dp, bottom = 8.dp)
                } else {
                    Modifier.padding(end = 20.dp, bottom = 8.dp)
                }
                EventNeedItem(
                    eventNeedItem = eventNeedItem,
                    onClick = onItemClick,
                    modifier = modifierItem
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@Preview
@Composable
fun PreviewSavedItemScreen() {
    EventhngsTheme {
        Surface {
            SavedItemScreen()
        }
    }
}
