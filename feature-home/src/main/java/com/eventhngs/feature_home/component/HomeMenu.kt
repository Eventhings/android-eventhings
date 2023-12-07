package com.eventhngs.feature_home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_home.domain.MenuItem
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.R

@Composable
fun HomeMenu(
    modifier: Modifier = Modifier,
    menuItems: List<MenuItem> = emptyList(),
    onClick: (MenuItem) -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(menuItems.size) { iteration ->
            MenuItem(
                menu = menuItems[iteration],
                onClick = onClick
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeMenu() {
    EventhngsTheme {
        val menuItems = listOf(
            MenuItem(icon = R.drawable.ic_menu_all, label = R.string.label_all),
            MenuItem(icon = R.drawable.ic_menu_media_partner, label = R.string.label_media_partner),
            MenuItem(icon = R.drawable.ic_menu_sponsorship, label = R.string.label_sponsor),
            MenuItem(icon = R.drawable.ic_menu_equipment, label = R.string.label_equipment),
        )

        Surface {
            HomeMenu(
                menuItems = menuItems,
                modifier = Modifier.padding(36.dp)
                    .fillMaxWidth()
            )
        }
    }
}
