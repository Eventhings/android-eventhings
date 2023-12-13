package com.eventhngs.ui.component.numbertext

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun TextWithBullet(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(modifier = modifier) {
        Text(
            text = "\uD83D\uDFE2",
            fontSize = 12.4.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            fontSize = 12.4.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            color = Color(0xFF404040),
            textAlign = TextAlign.Justify,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewTextWithBullet() {
    EventhngsTheme {
        Surface {
            TextWithBullet(
                text = "Lorem ipsum",
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
