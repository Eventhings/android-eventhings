package com.eventhngs.feature_sponsor_menu.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.feature_sponsor_menu.component.DetailSponsorHeader
import com.eventhngs.feature_sponsor_menu.component.DetailSponsorInformationSection
import com.eventhngs.feature_sponsor_menu.domain.SponsorDetail
import com.eventhngs.ui.component.bottomnavigation.DetailBottomNavigation
import com.eventhngs.ui.component.event.EventNeedItem
import com.eventhngs.ui.component.text.TextWithSeeMoreButton
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun DetailSponsorScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    sponsorId: Int = 0
) {

    val context = LocalContext.current

    val detail = SponsorDetail(
        id = 1,
        logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUH5yNyZx5JsPQZUSqbLcRdfyPueryOc_8Wg&usqp=CAU",
        name = "Coca-Cola",
        label = listOf("Equipment", "Sponsor", "Media Partner"),
        price = 100_000.0,
        rating = 4.0,
        email = "info@coca-cola.co.id",
        website = "https://google.com",
        instagram = "@abdulhafizramadan_",
        whatsapp = "081327464575",
        stepsToBook = listOf("Go to our website", "Fill the sponsorship data", "Regularly check email for the further information regarding the agreement (max. 2 weeks)", "Send MOU"),
        stepsAfterBook = listOf("Send Invoice"),
        about = "The Coca-Cola Company is a multinational beverage corporation known for its iconic soft drink brand, Coca-Cola. Coca-Cola was created by Dr. John Stith Pemberton in 1886 in Atlanta, Georgia, USA. The drink was initially intended as a patent medicine but evolved into the world-famous beverage. The Coca-Cola Company offers a diverse range of beverages, including carbonated soft drinks, non-carbonated beverages, juices, sports drinks, teas, and bottled water. Coca-Cola products are available in virtually every country around the world. The company operates in numerous markets, with a vast distribution network.",
        value = listOf("Coca-Cola is the world's most valuable brand, valued at over \$81 billion in 2023", "Coca-Cola has introduced over 3,500 beverage products throughout its history", "Coca-Cola is truly global, distributing its products in over 200 countries and territories")
    )

    val similarMediaPartners = (1..10).map {
        EventNeedItem(
            id = it,
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
                DetailSponsorHeader(
                    detail = detail,
                    onWebsiteClick = onWebsiteClick,
                    onInstagramClick = onInstagramClick,
                    onWhatsappClick = onWhatsappClick,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                DetailSponsorInformationSection(
                    detail = detail,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item {
                Divider(
                    thickness = 0.3.dp,
                    color = Color(0xFF4D4D4D),
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
                )
            }
            item {
                TextWithSeeMoreButton(
                    text = "Similar Sponsor",
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                )
            }
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
