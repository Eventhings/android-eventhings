package com.eventhngs.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 12.sp,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Medium,
        lineHeight = 30.sp,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .shadow(elevation = 30.dp, spotColor = Color(0xFF9365CD), ambientColor = Color(0xFF9365CD))
            .clip(RoundedCornerShape(size = 10.dp))
            .clickable(enabled = enabled) { onClick() }
            .background(color = Color(0xFFFFFFFF))
            .padding(horizontal = 12.dp, vertical = 4.dp)

    )
}

@Preview
@Composable
fun PreviewSecondaryButton() {
    EventhngsTheme {
        Surface {
            SecondaryButton(text = "Click me")
        }
    }
}