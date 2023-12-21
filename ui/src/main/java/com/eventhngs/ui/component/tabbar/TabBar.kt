package com.eventhngs.ui.component.tabbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.Purple1
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun TabBar(
    modifier: Modifier = Modifier,
    onPurchasedClick: () -> Unit = {}
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabTitles = listOf("Purchased", "Invoice")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.LightGray,
            contentColor = Purple1
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

            }
            1 -> {

            }

        }
    }

}

@Preview
@Composable
fun TopBarPreview() {
    EventhngsTheme {
        TabBar(
            modifier = Modifier.fillMaxSize()
        )
    }

}