package com.eventhngs.feature_media_partner_menu.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.Resource
import com.eventhngs.feature_media_partner_menu.component.DetailMediaPartnerHeader
import com.eventhngs.feature_media_partner_menu.component.DetailMediaPartnerInformationSection
import com.eventhngs.feature_media_partner_menu.component.DetailMediaPartnerPackageSection
import com.eventhngs.feature_media_partner_menu.domain.MediaPartnerPackage
import com.eventhngs.feature_media_partner_menu.mapper.toUi
import com.eventhngs.ui.component.bottomnavigation.DetailBottomNavigation
import com.eventhngs.ui.component.event.EventNeedItem
import com.eventhngs.ui.component.review.ReviewItem
import com.eventhngs.ui.component.text.TextWithSeeMoreButton
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun DetailMediaPartnerScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailMediaPartnerViewModel = koinViewModel(),
    mediaPartnerId: String = "002ad707-8006-4c7f-9d98-19e0650cff0d",
    navigateUp: () -> Unit = {}
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { 2 })

    val buttonTitle = remember(key1 = pagerState.currentPage) {
        if (pagerState.currentPage == 0) "Choose Package" else "Book Now"
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val detail = uiState.detailMediaPartner

    LaunchedEffect(key1 = Unit) {
        viewModel.getDetailMediaPartner(mediaPartnerId)
    }

//    val detail = MediaPartnerDetail(
//        id = 1,
//        logo = "https://pbs.twimg.com/profile_images/1281601097581211648/ZUwX2det_400x400.jpg",
//        name = "Your Business",
//        label = listOf("Equipment", "Sponsor", "Media Partner"),
//        price = 100_000.0,
//        rating = 4.0,
//        email = "marketing@seputarkampus.com",
//        website = "https://google.com",
//        instagram = "@abdulhafizramadan_",
//        whatsapp = "081327464575",
//        stepsToBook = listOf(
//            "Choose package",
//            "Add quantity",
//            "Invoice and payment",
//            "Send poster and caption"
//        ),
//        stepsAfterBook = listOf(
//            "Wait for the upload schedule and stay tune at our social media"
//        ),
//        about = "MagangUpdate Network is an informative and educative media about the world of internships. This media has been around since 2012 and has experience in collaborating with various event activities and companies.",
//        value = listOf(
//            "Top 1 Platform Sharing Internships and Jobs Information in Indonesia",
//            "We have had and maintained relationships with 10+ Universities, 40+ Enterprise & Start-up, and 1000+ Event Partners"
//        )
//    )

    val packageOptions = remember {
        mutableStateListOf<MediaPartnerPackage>()
    }

    val similarMediaPartners = (1..10).map {
        EventNeedItem(
            id = it.toString(),
            logo = "",
            title = "Your Business Name Here",
            label = listOf("Equipment", "Sponsor"),
            price = 100_000.0,
            rating = 4.0
        )
    }

    val onWebsiteClick: (String) -> Unit = { url ->
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

    val onInstagramClick: (String) -> Unit = { username ->
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/$username"))
        context.startActivity(intent)
    }

    val onWhatsappClick: (String) -> Unit = { number ->
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/$number"))
        context.startActivity(intent)
    }

    val onPackageCounterClick: (MediaPartnerPackage) -> Unit = { updatedPackage ->
        val packages = packageOptions.map {
            if (updatedPackage.id == it.id) updatedPackage
            else it
        }
        packageOptions.clear()
        packageOptions.addAll(packages)
    }

    val onButtonClick: () -> Unit = {
        scope.launch {
            when (pagerState.currentPage) {
                0 -> pagerState.animateScrollToPage(1)
                1 -> {}
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
        bottomBar = {
            DetailBottomNavigation(
                text = buttonTitle,
                onButtonClick = onButtonClick
            )
        },
        modifier = modifier.navigationBarsPadding()
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .navigationBarsPadding()
                .animateContentSize(),
            contentPadding = paddingValues,
        ) {
            if (detail is Resource.Success) {
                val detailUi = detail.data.toUi()
                item {
                    DetailMediaPartnerHeader(
                        detail = detailUi,
                        onWebsiteClick = onWebsiteClick,
                        onInstagramClick = onInstagramClick,
                        onWhatsappClick = onWhatsappClick,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color(0xFF9365CD) else Color(
                                0xFFEBE5F2
                            )
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(8.dp)
                        )
                    }
                }
            }
            if (detail is Resource.Success) {
                val detailUi = detail.data.toUi()
                packageOptions.addAll(
                    detail.data.packages.map {
                        MediaPartnerPackage(
                            id = it.id,
                            name = it.name,
                            benefits = it.description.split("\n"),
                            price = it.price
                        )
                    }
                )
                item {
                    HorizontalPager(
                        state = pagerState,
                        verticalAlignment = Alignment.Top
                    ) { page ->
                        when (page) {
                            0 -> DetailMediaPartnerInformationSection(
                                detail = detailUi,
                                modifier = Modifier.padding(horizontal = 20.dp)
                            )

                            1 -> DetailMediaPartnerPackageSection(
                                modifier = Modifier.padding(horizontal = 20.dp),
                                packages = packageOptions,
                                onDecreaseClick = onPackageCounterClick,
                                onIncreaseClick = onPackageCounterClick
                            )
                        }
                    }
                }
            }
            item {
                Divider(
                    thickness = 0.3.dp,
                    color = Color(0xFF4D4D4D),
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
                )
            }
            item { Spacer(modifier = Modifier.height(15.dp)) }
            item {
                TextWithSeeMoreButton(
                    text = "Service Ratings",
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                )
            }
            if (detail is Resource.Success) {
                items(items = detail.data.reviews, key = { it.id }) {
                    ReviewItem(
                        reviewItem = it,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
            item {
                TextWithSeeMoreButton(
                    text = "Similar Media Partner",
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                )
            }
            item {
                if (detail is Resource.Success) {
                    LazyRow(
                        contentPadding = PaddingValues(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(items = similarMediaPartners, key = { it.id }) { eventNeedItem ->
                            EventNeedItem(
                                eventNeedItem = eventNeedItem,
                                modifier = Modifier.widthIn(
                                    min = 175.dp,
                                    max = 230.dp
                                )
                            )
                        }
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
