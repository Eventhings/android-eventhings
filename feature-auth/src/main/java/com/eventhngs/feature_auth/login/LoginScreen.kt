package com.eventhngs.feature_auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eventhngs.ui.component.button.BaseButton
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Column {
        BaseButton(text = "Halaman Login")

    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    EventhngsTheme {
        Surface {
            LoginScreen()
        }
    }
}
