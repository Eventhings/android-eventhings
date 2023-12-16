package com.eventhngs.ui.component.button

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString

@Composable
fun BaseClickableText(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = TextStyle.Default,
    onClick: () -> Unit = {}
) {
    ClickableText(
        modifier = modifier,
        text = buildAnnotatedString {
            append(text)
        },
        style = textStyle,
        onClick = { onClick() }
    )
}