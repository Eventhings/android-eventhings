package com.eventhngs.feature_add_business

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_add_business.component.MarketBusinessRow
import com.eventhngs.feature_add_business.component.PromoMarketSection
import com.eventhngs.feature_add_business.component.TextTitle
import com.eventhngs.feature_add_business.domain.MarketBusiness
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
@Composable
fun AddBusinessScreen(
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()
    val marketBusinesses = listOf(
        MarketBusiness(
            img = R.drawable.img_2_5_million_user,
            title = R.string.title_2_5_million_user,
            description = R.string.desc_2_5_million_user
        ),
        MarketBusiness(
            img = R.drawable.img_easy_to_monitor,
            title = R.string.title_easy_to_monitor,
            description = R.string.desc_easy_to_monitor
        ),
        MarketBusiness(
            img = R.drawable.img_ai_power,
            title = R.string.title_ai_power,
            description = R.string.desc_ai_power
        )
    )

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Market Your Businesses",
                onNavigationClick = {}
            )
        },
        bottomBar = {
            PromoMarketSection(
                promoDate = "Feb 30th, 2024",
                price = 199_000.0,
                onMarketBusinessClicked = {},
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp)
                    .navigationBarsPadding()
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            TextTitle(
                text = "Upload your event related businesses at Eventh!ngs and enjoy the benefits!",
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            marketBusinesses.forEach {
                MarketBusinessRow(
                    marketBusiness = it,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewAddBusinessScreen() {
    EventhngsTheme {
        Surface {
            AddBusinessScreen()
        }
    }
}
