package com.eventhngs.ui.component.text

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.R
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun TextWithLikeIcon(
    modifier: Modifier = Modifier,
    like: Int = 0,
    isLiked: Boolean = false,
    onClick: () -> Unit = {}
) {
    val likeIcon = if (isLiked) R.drawable.ic_liked else R.drawable.ic_like
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = like.toString(),
            fontSize = 10.sp,
            lineHeight = 15.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight(500),
            color = Color(0xFF787878),
            modifier = Modifier.offset(y = 1.dp)
        )
        Image(
            painter = painterResource(id = likeIcon),
            contentDescription = "Like or dislike",
            modifier = Modifier.clip(CircleShape)
                .clickable { onClick() }
                .padding(4.dp)
        )
    }
}

@Preview
@Composable
fun PreviewTextWithLikeIcon() {
    EventhngsTheme {
        Surface {
            TextWithLikeIcon(
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
