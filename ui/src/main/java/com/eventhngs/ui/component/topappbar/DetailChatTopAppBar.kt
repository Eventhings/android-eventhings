package com.eventhngs.ui.component.topappbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.ui.R
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun DetailChatTopAppBar(
    modifier: Modifier = Modifier,
    image: String,
    title: String,
    subtitle: String,
    onNavigationClick: () -> Unit = {}
) {
    Column {
        Row(
            modifier = modifier.padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigationClick) {
                Image(
                    painter = painterResource(id = R.drawable.ic_chat_back),
                    contentDescription = "Back"
                )
            }
            AsyncImage(
                model = image,
                contentDescription = title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = title,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF2D2D2D),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color(0xFF000000),
                    modifier = Modifier.offset(y = (-4).dp)
                )
            }
        }
        Divider(
            modifier = Modifier.padding(horizontal = 20.dp),
            thickness = 0.5.dp,
            color = Color(0xFFA4A4A4)
        )
    }
}

@Preview
@Composable
fun PreviewDetailChatTopAppBar() {
    EventhngsTheme {
        Surface {
            DetailChatTopAppBar(
                image = "",
                title = "1000 Startup Digital",
                subtitle = "Sponsor"
            )
        }
    }
}
