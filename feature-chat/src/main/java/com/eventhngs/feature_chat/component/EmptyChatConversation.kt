package com.eventhngs.feature_chat.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.feature_chat.R
import com.eventhngs.feature_chat.domain.DetailChatHeader
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun EmptyChatConversation(
    modifier: Modifier = Modifier,
    info: DetailChatHeader
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = info.photo,
            contentDescription = info.name,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = info.name,
            fontSize = 24.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D),
            textAlign = TextAlign.Center
        )
        Text(
            text = info.type,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            color = Color(0xFF000000),
            textAlign = TextAlign.Center
        )
        Text(
            text = info.tagline,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight(400),
            color = Color(0xFF000000),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(62.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Start messaging now!",
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = poppinsFontFamily,
                color = Color(0xFF000000),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun PreviewEmptyChatConversation() {
    EventhngsTheme {
        Surface {
            val detail = DetailChatHeader(
                photo = "https://pbs.twimg.com/profile_images/1281601097581211648/ZUwX2det_400x400.jpg",
                name = "Magang Update",
                type = "Sponsor",
                tagline = "in goals to ingnite 1000+ startup in Indonesia every year."
            )
            EmptyChatConversation(
                info = detail,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
            )
        }
    }
}
