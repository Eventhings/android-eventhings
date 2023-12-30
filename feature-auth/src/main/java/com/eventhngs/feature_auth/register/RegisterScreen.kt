package com.eventhngs.feature_auth.register

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eventhngs.domain.model.Resource
import com.eventhngs.feature_auth.R
import com.eventhngs.ui.component.button.LoginWithGoogleButton
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
fun RegisterScreen(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = koinViewModel()
) {

    val scrollState = rememberScrollState()

    val dialogState = rememberUseCaseState(visible = false)
    var message by remember { mutableStateOf("") }

    val uiState by viewModel.registerUiState.collectAsStateWithLifecycle()

    val email = uiState.email
    val password = uiState.password
    val registerResult = uiState.registerResult

    val buttonRegisterEnabled by viewModel.buttonRegisterEnabled.collectAsStateWithLifecycle(
        initialValue = false
    )

    val buttonRegisterLoading by viewModel.buttonRegisterLoading.collectAsStateWithLifecycle(
        initialValue = false
    )

    LaunchedEffect(key1 = registerResult) {
        if (registerResult is Resource.Error) {
            message = registerResult.message.toString()
            dialogState.show()
            viewModel.updatePassword("")
        }
        if (registerResult is Resource.Success) {
            message = "User with email ${registerResult.data.email}, success created!"
            dialogState.show()
            viewModel.updatePassword("")
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
            Text(text = message)
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
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.eventhings_logo_small),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(255.dp)
                    .height(90.dp)
            )
            Spacer(modifier = Modifier.height(60.dp))
            BaseLargeTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = viewModel::updateEmail,
                label = "",
                placeholder = "Email"
            )
            Spacer(modifier = Modifier.height(20.dp))
            BasePasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = viewModel::updatePassword,
                placeholder = "Password"
            )
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(
                text = "Continue",
                onClick = viewModel::register,
                enabled = buttonRegisterEnabled,
                loading = buttonRegisterLoading,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(25.dp))
            RegisterDivider(
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(25.dp))
            LoginWithGoogleButton(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun RegisterDivider(modifier: Modifier = Modifier) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color(0xFFA4A4A4),
            thickness = 0.5.dp
        )
        Text(
            text = "or",
            fontSize = 14.sp,
            fontFamily = poppinsFontFamily
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color(0xFFA4A4A4),
            thickness = 0.5.dp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    EventhngsTheme {
        RegisterScreen()
    }
}