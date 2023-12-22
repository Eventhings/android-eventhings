package com.eventhngs.feature_create.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TabBarCreateBusiness()
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Basic Information"
            )

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