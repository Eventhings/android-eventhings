package com.eventhngs.feature_home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_home.domain.CarouselItem
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalFoundationApi
@Composable
fun HomeCarousel(
    modifier: Modifier = Modifier,
    carouselItems: List<CarouselItem> = emptyList(),
    onClick: (CarouselItem) -> Unit = {}
) {
    val pagerState = rememberPagerState(pageCount = { carouselItems.size })
    Column {
        HorizontalPager(state = pagerState) { index ->
            HomeCarouselItem(
                carouselItem = carouselItems[index],
                onClick = onClick,
                modifier = modifier
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewHomeCarousel() {
    EventhngsTheme {
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

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                HomeCarousel(
                    carouselItems = carouselItems,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}
