package com.eventhngs.feature_auth.enterotp

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_auth.R
import com.eventhngs.ui.component.button.PrimaryButton
import com.eventhngs.ui.component.text.BodyText
import com.eventhngs.ui.component.text.PrimaryText
import com.eventhngs.ui.component.textfield.BaseOtpTextField
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
@Composable
fun EnterOtpScreen(
    modifier: Modifier = Modifier,
    navigateToResetPasswordScreen: () -> Unit = {}
) {

    val scrollState = rememberScrollState()
    var otp by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(92.dp))
            Image(
                painter = painterResource(id = R.drawable.img_enter_otp),
                contentDescription = "enter otp",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(82.dp))
            PrimaryText(
                text = "Enter OTP",
                modifier = Modifier.padding(horizontal = 45.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            BodyText(
                text = "We have sent you an email and there is a code there. Please enter it!",
                modifier = Modifier.padding(horizontal = 45.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            BaseOtpTextField(
                value = otp,
                onValueChange = { value, _ -> otp = value },
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(42.dp))
            PrimaryButton(
                text = "Continue",
                onClick = navigateToResetPasswordScreen,
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
fun PreviewEnterOtpScreen() {
    EventhngsTheme {
        Surface {
            EnterOtpScreen()
        }
    }
}
