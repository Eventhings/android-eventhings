package com.eventhngs.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PreviewBaseButton() {
    EventhngsTheme {
        Surface {
            BaseButton(text = "Click me")
        }
    }
}
