package com.eventhngs.feature_notification.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_notification.domain.NotificationItem
import com.eventhngs.ui.R
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun NotificationItem(
    modifier: Modifier = Modifier,
    notification: NotificationItem,
    onClick: (NotificationItem) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .clickable { onClick(notification) }
            .then(modifier)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Image(
                painter = painterResource(id = notification.icon),
                contentDescription = notification.title,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = notification.title,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF2D2D2D)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = notification.description,
                    fontSize = 11.sp,
                    lineHeight = 16.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF787878)
                )
            }
        }
        Divider(color = Color(0xFFC6C6C6))
    }
}

@Preview
@Composable
fun PreviewNotificationItem() {
    EventhngsTheme {
        Surface {
            val notification = NotificationItem(
                id = 1,
                icon = R.drawable.ic_menu_all,
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum facilisis interdum augue eu sollicitudin."
            )
            NotificationItem(
                notification = notification,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
