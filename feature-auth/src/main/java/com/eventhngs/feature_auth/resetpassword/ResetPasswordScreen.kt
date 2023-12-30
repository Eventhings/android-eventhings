package com.eventhngs.feature_auth.resetpassword

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
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
import com.eventhngs.ui.component.textfield.BaseLargeTextField
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.blue1

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ResetPasswordScreen(
    modifier: Modifier = Modifier,
    navigateToResetPasswordSuccessScreen: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Scaffold(
        modifier = modifier
            .navigationBarsPadding()
            .safeDrawingPadding()
    ) { _ ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center
        ) {
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
                color = blue1,
                modifier = Modifier.padding(horizontal = 45.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            BodyText(
                text = "Please enter reset your new password, and reconfirm",
                modifier = Modifier.padding(horizontal = 45.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            BaseLargeTextField(
                value = "",
                onValueChange = {},
                placeholder = "New  Password",
                label = "",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(22.dp))
            BaseLargeTextField(
                value = "",
                onValueChange = {},
                placeholder = "Confirm Password",
                label = "",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(42.dp))
            PrimaryButton(
                text = "Continue",
                onClick = navigateToResetPasswordSuccessScreen,
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
