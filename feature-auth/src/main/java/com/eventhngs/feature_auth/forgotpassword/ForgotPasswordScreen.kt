package com.eventhngs.feature_auth.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_auth.R
import com.eventhngs.ui.component.button.PrimaryButton
import com.eventhngs.ui.component.text.BodyText
import com.eventhngs.ui.component.text.PrimaryText
import com.eventhngs.ui.component.textfield.BaseOutlinedTextField
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.blue1

@ExperimentalMaterial3Api
@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navigateToEnterOtpScreen: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Scaffold(modifier = modifier.safeDrawingPadding()) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(96.dp))
            Image(
                painter = painterResource(id = R.drawable.img_forgot_password),
                contentDescription = "forgot password",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(82.dp))
            PrimaryText(
                text = "Forgot\nPassword?",
                color = blue1,
                modifier = Modifier.padding(horizontal = 45.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            BodyText(
                text = "No worries! We will help You reset and remember it again",
                modifier = Modifier.padding(horizontal = 45.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            BaseOutlinedTextField(
                value = "",
                onValueChange = {},
//                label = "Email",
//                placeholder = "Email",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(42.dp))
            PrimaryButton(
                text = "Continue",
                onClick = navigateToEnterOtpScreen,
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewForgotPasswordScreen() {
    EventhngsTheme {
        Surface {
            ForgotPasswordScreen()
        }
    }
}
