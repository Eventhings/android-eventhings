package com.eventhngs.ui.component.tabbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.Purple1
import com.eventhngs.ui.theme.grey1

@Composable
fun TabBarCreateBusiness(
    modifier: Modifier = Modifier,
    onPurchasedClick: () -> Unit = {}
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabTitles = listOf(
        "1. General", "2. Details", "3. Package"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            contentColor = grey1
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title) },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (selectedTabIndex) {
            0 -> {
                "Screen General"
            }
            1 -> {
                "Screen Details"
            }
            2 -> {

            }

        }
    }

}

@Preview
@Composable
fun TopBarCreateBusinessPreview() {
    EventhngsTheme {
        TabBarCreateBusiness(
            modifier = Modifier.fillMaxSize()
        )
    }

}