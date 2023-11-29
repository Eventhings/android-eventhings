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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_home.component.EventNeedItem
import com.eventhngs.feature_home.component.HomeCarousel
import com.eventhngs.feature_home.component.HomeFooter
import com.eventhngs.feature_home.component.HomeHeader
import com.eventhngs.feature_home.component.HomeMenu
import com.eventhngs.feature_home.domain.CarouselItem
import com.eventhngs.feature_home.domain.EventNeedItem
import com.eventhngs.feature_home.domain.MenuItem
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val user by remember { mutableStateOf("Abdul Hafiz Ramadan") }

    val carouselItems = (1..3).map {
        CarouselItem(
            id = it,
            logo = "",
            title = "Your Business Name Here",
            label = "Eventh!ngs of the Day!",
            price = 100_000.0,
            rating = 4.0
        )
    }

    val menuItems = listOf(
        MenuItem(icon = R.drawable.ic_menu_all, label = R.string.label_all),
        MenuItem(icon = R.drawable.ic_menu_media_partner, label = R.string.label_media_partner),
        MenuItem(icon = R.drawable.ic_menu_sponsorship, label = R.string.label_sponsor),
        MenuItem(icon = R.drawable.ic_menu_equipment, label = R.string.label_equipment),
    )

    val eventNeedItems = (1..10).map {
        EventNeedItem(
            id = it,
            logo = "",
            title = "Your Business Name Here",
            label = listOf("Equipment", "Sponsor", "Media Partner", "Photo Booth"),
            price = 100_000.0,
            rating = 4.0
        )
    }

    Scaffold(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.navigationBarsPadding()
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                HomeHeader(user = user, modifier = Modifier)
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
                    modifier = Modifier
                        .padding(horizontal = 36.dp)
                        .fillMaxWidth()
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
            itemsIndexed(items = eventNeedItems, key = { _, event -> event.id }) { index, eventNeedItem ->
                val modifier = if (index % 2 == 0) {
                    Modifier.padding(start = 20.dp, bottom = 8.dp)
                } else {
                    Modifier.padding(end = 20.dp, bottom = 8.dp)
                }
                EventNeedItem(
                    eventNeedItem = eventNeedItem,
                    modifier = modifier
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                HomeFooter(
                    modifier = Modifier.padding(20.dp)
                )
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
