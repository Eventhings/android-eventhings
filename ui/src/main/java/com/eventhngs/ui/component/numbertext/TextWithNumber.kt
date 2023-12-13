package com.eventhngs.ui.component.numbertext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun TextWithNumber(
    modifier: Modifier = Modifier,
    number: Int,
    text: String
) {
    Row(modifier = modifier) {
        Text(
            text = number.toString(),
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 13.sp,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clip(CircleShape)
                .size(18.dp)
                .background(
                    brush = Brush.linearGradient(
                        0f to Color(0xff5d5fef),
                        1f to Color(0xffb5b6ff),
                        start = Offset(3f, 15.6f),
                        end = Offset(15f, 1.8f)
                    )
                )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            fontSize = 12.4.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight(400),
            color = Color(0xFF404040),
            textAlign = TextAlign.Justify,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewTextWithNumber() {
    EventhngsTheme {
        Surface {
            TextWithNumber(
                number = 1,
                text = "Lorem ipsum",
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
