package com.eventhngs.ui.component.text

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.Blue
import com.eventhngs.ui.theme.DarkGrey
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.Green
import com.eventhngs.ui.theme.LightBlue
import com.eventhngs.ui.theme.LightGreen
import com.eventhngs.ui.theme.LightRed
import com.eventhngs.ui.theme.Red
import com.eventhngs.ui.theme.poppinsFontFamily

enum class TextLabelType {
    Default,
    OutlinedWhite,
    FilledRed,
    FilledBlue,
    FilledGreen
}

enum class TextLabelSize {
    Small, Medium
}

fun String.generateLabelType(): TextLabelType {
    return when (this) {
        "Media Partner" -> TextLabelType.FilledRed
        "Equipment" -> TextLabelType.FilledBlue
        "Sponsor" -> TextLabelType.FilledGreen
        else -> TextLabelType.Default
    }
}

@Composable
fun TextLabel(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit = 9.sp,
    type: TextLabelType = TextLabelType.OutlinedWhite,
    size: TextLabelSize = TextLabelSize.Medium
) {
    val textColor = when (type) {
        TextLabelType.Default -> DarkGrey
        TextLabelType.OutlinedWhite -> Color.White
        TextLabelType.FilledRed -> Red
        TextLabelType.FilledBlue -> Blue
        TextLabelType.FilledGreen -> Green
    }
    val borderColor = when (type) {
        TextLabelType.Default -> DarkGrey
        TextLabelType.OutlinedWhite -> Color.White
        TextLabelType.FilledRed -> LightRed
        TextLabelType.FilledBlue -> LightBlue
        TextLabelType.FilledGreen -> LightGreen
    }
    val backgroundColor = when (type) {
        TextLabelType.Default -> Color.Transparent
        TextLabelType.OutlinedWhite -> Color.Transparent
        TextLabelType.FilledRed -> LightRed
        TextLabelType.FilledBlue -> LightBlue
        TextLabelType.FilledGreen -> LightGreen
    }
    val textPadding = when (size) {
        TextLabelSize.Small -> 5.dp
        TextLabelSize.Medium -> 10.dp
    }
    Text(
        text = text,
        lineHeight = 20.sp,
        fontSize = textSize,
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Medium,
        color = textColor,
        textAlign = TextAlign.Center,
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .clip(RoundedCornerShape(size = 10.dp))
            .background(backgroundColor)
            .padding(horizontal = textPadding, vertical = 2.dp)
    )
}

@Preview
@Composable
fun PreviewTextLabel() {
    EventhngsTheme {
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Column {
                TextLabel(
                    text = "Eventh!ngs of the Day!",
                    modifier = Modifier.padding(16.dp)
                )
                TextLabel(
                    text = "Eventh!ngs of the Day!",
                    modifier = Modifier.padding(16.dp),
                    type = TextLabelType.Default
                )
                TextLabel(
                    text = "Eventh!ngs of the Day!",
                    modifier = Modifier.padding(16.dp),
                    type = TextLabelType.FilledBlue
                )
                TextLabel(
                    text = "Eventh!ngs of the Day!",
                    modifier = Modifier.padding(16.dp),
                    type = TextLabelType.FilledGreen
                )
                TextLabel(
                    text = "Eventh!ngs of the Day!",
                    modifier = Modifier.padding(16.dp),
                    type = TextLabelType.FilledRed
                )
            }
        }
    }
}
