package com.eventhngs.feature_chat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun ChatDateDivider(
    modifier: Modifier = Modifier,
    date: String
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 2.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = date,
            fontSize = 12.sp,
            lineHeight = 25.sp,
            fontFamily = poppinsFontFamily,
            color = Color(0xFFA4A4A4)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Divider(
            thickness = 0.5.dp,
            color = Color(0xFFA4A4A4)
        )
    }
}

@Preview
@Composable
fun PreviewChatDateDivider() {
    EventhngsTheme {
        Surface {
            ChatDateDivider(
                date = "12 September 2023",
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
