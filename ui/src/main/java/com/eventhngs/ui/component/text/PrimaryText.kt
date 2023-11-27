package com.eventhngs.ui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun PrimaryText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    fontSize: TextUnit = 24.sp,
    letterSpacing: TextUnit = 0.48.sp,
    fontWeight: FontWeight = FontWeight.SemiBold
) {
    BaseText(
        modifier = modifier,
        letterSpacing = letterSpacing,
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
}

@Preview
@Composable
fun PreviewPrimaryText() {
    EventhngsTheme {
        Surface {
            PrimaryText(
                text = "Forgot \nPassword?"
            )
        }
    }
}
