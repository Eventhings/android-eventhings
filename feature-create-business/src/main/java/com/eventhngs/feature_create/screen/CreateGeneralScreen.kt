package com.eventhngs.feature_create.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.feature_create.component.general.GeneralBasicInformation
import com.eventhngs.feature_create.component.general.GeneralBusinessProfile
import com.eventhngs.ui.component.tabbar.TabBarCreateBusiness
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme


@OptIn(ExperimentalMaterial3Api::class)
@androidx.compose.runtime.Composable
fun CreatGeneralScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
) {

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Create Business",
                onNavigationClick = navigateUp
            )
        }
    ) {paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                TabBarCreateBusiness(
                    onPurchasedClick = {}
                )
            }
            item {
                GeneralBasicInformation()
            }
            item {
                GeneralBusinessProfile(eventNeedItem = EventNeedItem() )
            }

        }

    }
}

@Preview
@Composable
fun CreateGeneralScreenPreview() {
    EventhngsTheme {
        Surface {
            CreatGeneralScreen()
        }
    }
    
}