package com.eventhngs.feature_sponsor_menu.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.Resource
import com.eventhngs.feature_sponsor_menu.component.DetailSponsorHeader
import com.eventhngs.feature_sponsor_menu.component.DetailSponsorInformationSection
import com.eventhngs.feature_sponsor_menu.mapper.toUi
import com.eventhngs.ui.component.bottomnavigation.DetailBottomNavigation
import com.eventhngs.ui.component.event.EventNeedItem
import com.eventhngs.ui.component.review.ReviewItem
import com.eventhngs.ui.component.text.TextWithSeeMoreButton
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme
import org.koin.androidx.compose.koinViewModel

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun DetailSponsorScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailSponsorViewModel = koinViewModel(),
    navigateUp: () -> Unit = {},
    sponsorId: String = ""
) {

    val context = LocalContext.current

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val detail = uiState.detailSponsor

    LaunchedEffect(key1 = Unit) {
        viewModel.getDetailSponsor(sponsorId)
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

    val onButtonClick: () -> Unit = {}

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Back",
                onNavigationClick = navigateUp
            )
        },
        bottomBar = {
            DetailBottomNavigation(
                text = "Choose Package",
                onButtonClick = onButtonClick
            )
        },
        modifier = modifier.navigationBarsPadding()
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.navigationBarsPadding(),
            contentPadding = paddingValues
        ) {
            item {
                if (detail is Resource.Success) {
                    val detailUi = detail.data.toUi()
                    DetailSponsorHeader(
                        detail = detailUi,
                        onWebsiteClick = onWebsiteClick,
                        onInstagramClick = onInstagramClick,
                        onWhatsappClick = onWhatsappClick,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }
            }
            item {
                if (detail is Resource.Success) {
                    val detailUi = detail.data.toUi()
                    DetailSponsorInformationSection(
                        detail = detailUi,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
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
                    text = "Similar Sponsor",
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                )
            }
            if (detail is Resource.Success) {
                item {
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
fun PreviewDetailSponsorScreen() {
    EventhngsTheme {
        Surface {
            DetailSponsorScreen()
        }
    }
}
