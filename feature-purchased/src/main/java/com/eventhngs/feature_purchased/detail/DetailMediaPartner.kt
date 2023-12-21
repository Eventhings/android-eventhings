package com.eventhngs.feature_purchased.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.feature_media_partner_menu.component.DetailMediaPartnerHeader
import com.eventhngs.feature_media_partner_menu.component.DetailMediaPartnerInformationSection
import com.eventhngs.feature_media_partner_menu.component.DetailMediaPartnerPackageSection
import com.eventhngs.feature_media_partner_menu.domain.MediaPartnerDetail
import com.eventhngs.feature_media_partner_menu.domain.MediaPartnerPackage
import com.eventhngs.feature_purchased.even.PackageOption
import com.eventhngs.ui.component.bottomnavigation.DetailBottomNavigation
import com.eventhngs.ui.component.event.EventNeedItem
import com.eventhngs.ui.component.text.TextWithSeeMoreButton
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Row as Row

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun DetailMediaPartnerScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    mediaPartnerId: Int = 0
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { 2 })
    var quantity by remember { mutableIntStateOf(1) }


    val detail = MediaPartnerDetail(
        id = "",
        logoUrl = "https://pbs.twimg.com/profile_images/1281601097581211648/ZUwX2det_400x400.jpg",
        name = "Your Business",
        label = listOf("Equipment", "Sponsor", "Media Partner"),
        stepsToBook = listOf(
            "Choose package",
            "Add quantity",
            "Invoice and payment",
            "Send poster and caption"
        ),
        stepsAfterBook = listOf(
            "Wait for the upload schedule and stay tune at our social media"
        ),
        value = listOf(
            "Top 1 Platform Sharing Internships and Jobs Information in Indonesia",
            "We have had and maintained relationships with 10+ Universities, 40+ Enterprise & Start-up, and 1000+ Event Partners"
        )
    )

    var packageOptions by remember {
        mutableStateOf(
            (1..5).map {
                MediaPartnerPackage(
                    id = it.toString(),
                    name = "Paket Bronze",
                    benefits = listOf("1x Feed @seputarkampus", "1x IG Story @seputarkampus", "1x IG Story @magangupdate", "1x Twit @seputarkampus"),
                    price = 50_000.0
                )
            }
        )
    }



    val onPackageCounterClick: (MediaPartnerPackage) -> Unit = { updatedPackage ->
        packageOptions = packageOptions.map {
            if (updatedPackage.id == it.id) updatedPackage
            else it
        }
    }

    val onButtonClick: () -> Unit = {
        scope.launch {
            when (pagerState.currentPage) {
                0 -> pagerState.animateScrollToPage(1)
                1 -> pagerState.animateScrollToPage(2)
            }
        }
    }

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Back",
                onNavigationClick = navigateUp
            )
        },
        modifier = modifier.navigationBarsPadding()
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.navigationBarsPadding(),
            contentPadding = paddingValues
        ) {
            item {
                DetailMediaPartnerHeader(
                    detail = detail,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                HorizontalPager(
                    state = pagerState,
                    verticalAlignment = Alignment.Top
                ) { page ->
                    when (page) {
                        0 -> PackageOption(
                            label = "Packet Bronze",
                            benefits = listOf("1x Feed @seputarkampus", "1x IG Story @seputarkampus", "1x IG Story @magangupdate", "1x Twit @seputarkampus"),
                            quantity = quantity,
                            onDecreaseClick = { quantity = it },
                            onIncreaseClick = { quantity = it },
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                        )
                        0 -> PackageOption(
                            label = "Packet Bronze",
                            benefits = listOf("1x Feed @seputarkampus", "1x IG Story @seputarkampus", "1x IG Story @magangupdate", "1x Twit @seputarkampus"),
                            quantity = quantity,
                            onDecreaseClick = { quantity = it },
                            onIncreaseClick = { quantity = it },
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                        )

                    }
                }

            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@Preview
@Composable
fun PreviewDetailMediaPartnerScreen() {
    EventhngsTheme {
        Surface {
            DetailMediaPartnerScreen()
        }
    }
}