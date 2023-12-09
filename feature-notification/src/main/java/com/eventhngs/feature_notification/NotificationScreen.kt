package com.eventhngs.feature_notification

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_notification.component.NotificationItem
import com.eventhngs.feature_notification.domain.NotificationItem
import com.eventhngs.ui.R
import com.eventhngs.ui.component.topappbar.BaseTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier
) {

    val notifications = (1..10).map {
        NotificationItem(
            id = it,
            icon = R.drawable.ic_menu_all,
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum facilisis interdum augue eu sollicitudin.",
            date = "23 Jan"
        )
    }

    Scaffold(
        topBar = {
            BaseTopAppBar(title = "Notifications")
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(items = notifications, key = { it.id }) { notification ->
                NotificationItem(
                    notification = notification,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewNotificationScreen() {
    EventhngsTheme {
        Surface {
            NotificationScreen()
        }
    }
}
