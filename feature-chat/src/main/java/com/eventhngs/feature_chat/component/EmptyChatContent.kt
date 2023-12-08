package com.eventhngs.feature_chat.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_chat.R
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun EmptyChatContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_no_chat),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "No Chat Found",
            fontSize = 24.sp,
            lineHeight = 30.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF535353),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Tidak ada obrolan ditemukan",
            fontSize = 14.sp,
            lineHeight = 30.sp,
            fontFamily = poppinsFontFamily,
            color = Color(0xFF535353),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewEmptyChatContent() {
    EventhngsTheme {
        Surface {
            EmptyChatContent(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
