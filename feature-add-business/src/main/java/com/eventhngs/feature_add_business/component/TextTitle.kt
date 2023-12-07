package com.eventhngs.feature_add_business.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun TextTitle(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        fontSize = 17.sp,
        lineHeight = 30.sp,
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF2D2D2D),
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewTextTitle() {
    EventhngsTheme {
        Surface {
            TextTitle(
                text = "Market Your Businesses",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
