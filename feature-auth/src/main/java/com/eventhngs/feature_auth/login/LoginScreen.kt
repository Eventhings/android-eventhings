package com.eventhngs.feature_auth.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eventhngs.domain.model.Resource
import com.eventhngs.feature_auth.R
import com.eventhngs.ui.component.button.BaseClickableText
import com.eventhngs.ui.component.button.PrimaryButton
import com.eventhngs.ui.component.textfield.BaseLargeTextField
import com.eventhngs.ui.component.textfield.BasePasswordTextField
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily
import com.maxkeppeker.sheets.core.CoreDialog
import com.maxkeppeker.sheets.core.models.CoreSelection
import com.maxkeppeker.sheets.core.models.base.SelectionButton
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import org.koin.androidx.compose.koinViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = koinViewModel(),
    navigateToMainScreen: () -> Unit = {},
    navigateToRegisterScreen: () -> Unit = {},
    navigateToForgotPasswordScreen: () -> Unit = {},
) {

    val scrollState = rememberScrollState()

    val dialogState = rememberUseCaseState(visible = false)
    var errorMessage by remember { mutableStateOf("") }

    val loginUiState by loginViewModel.loginUiState.collectAsStateWithLifecycle()

    val email = loginUiState.email
    val password = loginUiState.password
    val loginResult = loginUiState.loginResult

    val buttonLoginEnabled by loginViewModel.buttonLoginEnabled.collectAsStateWithLifecycle(
        initialValue = false
    )

    val buttonLoginLoading by loginViewModel.buttonLoginLoading.collectAsStateWithLifecycle(
        initialValue = false
    )

    LaunchedEffect(key1 = loginResult) {
        if (loginResult is Resource.Error) {
            errorMessage = loginResult.message.toString()
            dialogState.show()
        }
        if (loginResult is Resource.Success) {
            navigateToMainScreen()
        }
    }

    CoreDialog(
        state = dialogState,
        selection = CoreSelection(
            positiveButton = SelectionButton(
                text = "Ok"
            ),
            onPositiveClick = { dialogState.hide() },
            negativeButton = null
        ),
        body = {
            Text(text = errorMessage)
        }
    )

    Scaffold(
        modifier = modifier
            .navigationBarsPadding()
            .safeDrawingPadding()
    ) { _ ->
        Column(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .fillMaxSize()
                .verticalScroll(state = scrollState)
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.welcome),
                fontSize = 26.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF5D5FEF),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.desc_login),
                fontSize = 14.sp,
                lineHeight = 25.sp,
                fontFamily = poppinsFontFamily,
                color = Color(0xFF535353)
            )

            Spacer(modifier = Modifier.height(30.dp))
            BaseLargeTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = loginViewModel::updateEmail,
                placeholder = "Email"
            )
            Spacer(modifier = Modifier.height(20.dp))
            BasePasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = loginViewModel::updatePassword,
                placeholder = "Password"
            )
            Spacer(modifier = Modifier.height(34.dp))
            PrimaryButton(
                text = "Login",
                onClick = loginViewModel::login,
                enabled = buttonLoginEnabled,
                loading = buttonLoginLoading,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BaseClickableText(
                    text = "Register",
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF5D5FEF),
                    ),
                    onClick = navigateToRegisterScreen
                )
                BaseClickableText(
                    text = "Forgot password?",
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF4D4D4D),
                    ),
                    onClick = navigateToForgotPasswordScreen
                )
            }
        }
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    EventhngsTheme {
        Surface {
            LoginScreen()
        }
    }
}