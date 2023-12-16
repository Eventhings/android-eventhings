package com.eventhngs.feature_auth.resetpasswordsuccess

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_auth.R
import com.eventhngs.ui.component.button.PrimaryButton
import com.eventhngs.ui.component.text.BodyText
import com.eventhngs.ui.component.text.PrimaryText
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
@Composable
fun ResetPasswordSuccessScreen(
    modifier: Modifier = Modifier,
    navigateToLoginScreen: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Scaffold(modifier = modifier.navigationBarsPadding()) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(137.dp))
            Image(
                painter = painterResource(id = R.drawable.img_reset_password_success),
                contentDescription = "reset password success",
                modifier = Modifier
                    .padding(horizontal = 45.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(28.dp))
            PrimaryText(
                text = "Reset Successfull",
                modifier = Modifier.padding(horizontal = 45.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            BodyText(
                text = "Reset password successful, now find your event needs!",
                modifier = Modifier.padding(horizontal = 45.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(28.dp))
            PrimaryButton(
                text = "Done!",
                onClick = navigateToLoginScreen,
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
fun PreviewResetPasswordSuccessScreen() {
    EventhngsTheme {
        Surface {
            ResetPasswordSuccessScreen()
        }
    }
}
