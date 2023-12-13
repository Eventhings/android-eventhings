package com.eventhngs.ui.component.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun TextWithSeeMoreButton(
    modifier: Modifier = Modifier,
    text: String,
    textButton: String = "See More",
    onSeeMoreClick: () -> Unit = {}
) {
    val buttonText = buildAnnotatedString {
        withStyle(
            SpanStyle(
                fontSize = 15.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF9365CD)
            )
        ) {
            append(textButton)
        }
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            lineHeight = 30.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D)
        )
        ClickableText(text = buttonText, onClick = { onSeeMoreClick() })
    }
}

@Preview
@Composable
fun PreviewTextWithSeeMoreButton() {
    EventhngsTheme {
        Surface {
            TextWithSeeMoreButton(
                text = "Similar Media Partner",
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
