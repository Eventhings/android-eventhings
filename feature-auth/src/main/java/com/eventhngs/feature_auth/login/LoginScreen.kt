package com.eventhngs.feature_auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.ui.component.button.BaseButton
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToForgotPasswordScreen: () -> Unit = {},
    navigateToHomeScreen: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        BaseButton(
            text = "Ke Halaman Forgot Password",
            onClick = navigateToForgotPasswordScreen
        )
        BaseButton(
            text = "Ke Halaman Home",
            onClick = navigateToHomeScreen
        )
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
