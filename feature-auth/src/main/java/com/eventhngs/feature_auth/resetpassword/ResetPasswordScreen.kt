package com.eventhngs.feature_auth.resetpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@ExperimentalMaterial3Api
@Composable
fun ResetPasswordScreen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            Image(
                painter = painterResource(id = R.drawable.img_reset_password),
                contentDescription = "reset password",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(82.dp))
            PrimaryText(
                text = "Reset Password",
                modifier = Modifier.padding(horizontal = 45.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            BodyText(
                text = "Please enter reset your new password, and reconfirm",
                modifier = Modifier.padding(horizontal = 45.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            BaseOutlinedTextField(
                value = "",
                onValueChange = {},
                label = "New  Password",
                placeholder = "New  Password",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(22.dp))
            BaseOutlinedTextField(
                value = "",
                onValueChange = {},
                label = "Confirm Password",
                placeholder = "Confirm Password",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(42.dp))
            PrimaryButton(
                text = "Continue",
                onClick = {},
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
fun PreviewResetPasswordScreen() {
    EventhngsTheme {
        Surface {
            ResetPasswordScreen()
        }
    }
}
