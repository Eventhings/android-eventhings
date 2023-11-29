package com.eventhngs.feature_home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_home.R
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    user: String
) {
    Box(
        modifier = modifier
            .height(150.dp)
            .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_banner),
            contentDescription = "banner",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .matchParentSize()
                .padding(
                    start = 20.dp,
                    top = 55.dp,
                    end = 20.dp,
                    bottom = 25.dp
                )
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "\uD83D\uDC4B Hi, $user",
                fontSize = 12.sp,
                lineHeight = 30.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(10.dp))
            HomeSearchBar(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeHeader() {
    EventhngsTheme {
        Surface {
            HomeHeader(
                user = "Abdul Hafiz Ramadan",
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
