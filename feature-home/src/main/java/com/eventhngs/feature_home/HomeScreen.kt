package com.eventhngs.feature_home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType
import com.eventhngs.domain.model.Resource
import com.eventhngs.feature_home.component.HomeCarousel
import com.eventhngs.feature_home.component.HomeFooter
import com.eventhngs.feature_home.component.HomeHeader
import com.eventhngs.feature_home.component.HomeMenu
import com.eventhngs.feature_home.domain.CarouselItem
import com.eventhngs.feature_home.domain.MenuItem
import com.eventhngs.ui.R
import com.eventhngs.ui.component.button.TertiaryButton
import com.eventhngs.ui.component.event.EventNeedItem
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    navigateToAllMenuScreen: () -> Unit = {},
    navigateToMediaPartnerMenuScreen: () -> Unit = {},
    navigateToSponsorMenuScreen: () -> Unit = {},
    navigateToEquipmentMenuScreen: () -> Unit = {},
    navigateToMediaPartnerDetailScreen: (String) -> Unit = {},
    navigateToSponsorDetailScreen: (String) -> Unit = {},
    navigateToEquipmentDetailScreen: (String) -> Unit = {},
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val userPreference = uiState.userPreference
    val recommendations = uiState.recommendations

    val carouselItems = (1..3).map {
        CarouselItem(
            id = it,
            logo = "https://secure.gravatar.com/avatar/019341b43c34bb322f316e57312ecaef?s=500&d=blank&r=g",
            title = "Dicoding Akademi Indonesia",
            label = "Eventh!ngs of the Day!",
            price = 100_000.0,
            rating = 4.8
        )
    }

    val menuItems = listOf(
        MenuItem(icon = R.drawable.ic_menu_all, label = R.string.label_all),
        MenuItem(icon = R.drawable.ic_menu_media_partner, label = R.string.label_media_partner),
        MenuItem(icon = R.drawable.ic_menu_sponsorship, label = R.string.label_sponsor),
        MenuItem(icon = R.drawable.ic_menu_equipment, label = R.string.label_equipment),
    )

    LaunchedEffect(key1 = Unit) {
        viewModel.getUserPreference()
        viewModel.getRecommendations()
    }

//    val eventNeedItems = listOf(
//        EventNeedItem(
//            id = "1",
//            logo = "https://pbs.twimg.com/profile_images/1281601097581211648/ZUwX2det_400x400.jpg",
//            title = "Magang Update",
//            label = listOf("Media Partner", "Career"),
//            price = 100_000.0,
//            rating = 4.9,
//            type = EventNeedItemType.MEDIA_PARTNER
//        ),
//        EventNeedItem(
//            id = "2",
//            logo = "https://upload.wikimedia.org/wikipedia/commons/3/3b/Nutrifood.png",
//            title = "Nutrifood",
//            label = listOf("Equipment", "Bouquet"),
//            price = 0.0,
//            rating = 5.0,
//            type = EventNeedItemType.EQUIPMENT
//        ),
//        EventNeedItem(
//            id = "3",
//            logo = "https://media.licdn.com/dms/image/C4E0BAQG_rgylSaTLoA/company-logo_200_200/0/1630628774592/indonesian_event_logo?e=2147483647&v=beta&t=L_gC2hWXLZQZY9wpBzsu1sg57-MLAnV7L7MYVJoqzuA",
//            title = "Indonesian Event",
//            label = listOf("Media Partner", "Event"),
//            price = 25_000.0,
//            rating = 4.9,
//            type = EventNeedItemType.MEDIA_PARTNER
//        ),
//        EventNeedItem(
//            id = "4",
//            logo = "https://asset.kompas.com/crop/0x0:0x0/720x360/data/photo/2022/01/05/61d5532faf8e8.jpg",
//            title = "Indosat Ooredoo Hutchison",
//            label = listOf("Sponsor", "Telecommunication"),
//            price = 0.0,
//            rating = 5.0,
//            type = EventNeedItemType.EQUIPMENT
//        ),
//        EventNeedItem(
//            id = "5",
//            logo = "https://alexandra.bridestory.com/image/upload/assets/bride-S18nqs9SH.jpg",
//            title = "Owl Florist",
//            label = listOf("Equipment", "Bouquet"),
//            price = 100_000.0,
//            rating = 4.8,
//            type = EventNeedItemType.EQUIPMENT
//        ),
//        EventNeedItem(
//            id = "6",
//            logo = "https://st3.depositphotos.com/1050070/13129/i/450/depositphotos_131293830-stock-photo-coca-cola-logo-on-computer.jpg",
//            title = "Coca-Cola",
//            label = listOf("Sponsor", "Food & Beverage"),
//            price = 0.0,
//            rating = 4.5,
//            type = EventNeedItemType.SPONSOR
//        )
//    )

    val onItemClick: (EventNeedItem) -> Unit = {
        when (it.type) {
            EventNeedItemType.MEDIA_PARTNER -> navigateToMediaPartnerDetailScreen(it.id)
            EventNeedItemType.SPONSOR -> navigateToSponsorDetailScreen(it.id)
            EventNeedItemType.EQUIPMENT -> navigateToEquipmentDetailScreen(it.id)
        }
    }

    val onMenuClick: (MenuItem) -> Unit = { menu ->
        when (menu.label) {
            R.string.label_all -> navigateToAllMenuScreen()
            R.string.label_media_partner -> navigateToMediaPartnerMenuScreen()
            R.string.label_sponsor -> navigateToSponsorMenuScreen()
            R.string.label_equipment -> navigateToEquipmentMenuScreen()
        }
    }

    Scaffold(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.navigationBarsPadding()
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                HomeHeader(user = userPreference.name, modifier = Modifier)
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(25.dp))
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                HomeCarousel(
                    carouselItems = carouselItems,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                HomeMenu(
                    menuItems = menuItems,
                    onClick = onMenuClick,
                    modifier = Modifier
                        .padding(horizontal = 36.dp)
                        .fillMaxWidth(),
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = "Go find your event needs!🔥",
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF2D2D2D),
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(20.dp))
            }
            if (recommendations is Resource.Success) {
                itemsIndexed(items = recommendations.data, key = { _, event -> event.id }) { index, eventNeedItem ->
                    val modifierItem = if (index % 2 == 0) {
                        Modifier.padding(start = 20.dp, bottom = 8.dp)
                    } else {
                        Modifier.padding(end = 20.dp, bottom = 8.dp)
                    }
                    EventNeedItem(
                        eventNeedItem = eventNeedItem,
                        modifier = modifierItem,
                        onClick = onItemClick
                    )
                }

            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                TertiaryButton(
                    text = "See All",
                    onClick = navigateToAllMenuScreen,
                    modifier = Modifier.wrapContentWidth()
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                HomeFooter(
                    modifier = Modifier.padding(20.dp)
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewHomeScreen() {
    EventhngsTheme {
        Surface {
            HomeScreen()
        }
    }
}
