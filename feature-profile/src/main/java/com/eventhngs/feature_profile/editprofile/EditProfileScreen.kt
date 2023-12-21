package com.eventhngs.feature_profile.editprofile

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eventhngs.domain.model.Resource
import com.eventhngs.feature_profile.component.EditProfileHeader
import com.eventhngs.ui.component.button.SmallPrimaryButton
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabel
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabelType
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme
import com.maxkeppeker.sheets.core.CoreDialog
import com.maxkeppeker.sheets.core.models.CoreSelection
import com.maxkeppeker.sheets.core.models.base.SelectionButton
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import org.koin.androidx.compose.koinViewModel

@ExperimentalMaterial3Api
@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: EditProfileViewModel = koinViewModel(),
    navigateUp: () -> Unit = {},
    token: String = ""
) {

    val scrollState = rememberScrollState()
    val dialogState = rememberUseCaseState(visible = false)
    var message by remember { mutableStateOf("") }

    val img by remember { mutableStateOf("") }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val fullName = uiState.fullName
    val email = uiState.email
    val birthDate = uiState.birthDate
    val whatsappNumber = uiState.whatsapp
    val domicile = uiState.domicile

    val user = uiState.user
    val updateUserResult = uiState.updateUserResult

    val buttonEnabled by viewModel.buttonEnabled.collectAsStateWithLifecycle(initialValue = false)
    val buttonLoading by viewModel.buttonLoading.collectAsStateWithLifecycle(initialValue = false)

    LaunchedEffect(key1 = Unit) {
        viewModel.getUserLogging(token)
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

    LaunchedEffect(key1 = user) {
        if (user is Resource.Success) {
            val data = user.data
            viewModel.updateFullName(data.displayName)
            viewModel.updateEmail(data.email)
            viewModel.updateBirthDate(data.dob)
            viewModel.updateWhatsapp(data.phoneNumber)
            viewModel.updateDomicile(data.location)
        }
    }

    LaunchedEffect(key1 = updateUserResult) {
        if (updateUserResult is Resource.Success) {
            message = "Data updated successfully"
            dialogState.show()
        }
        if (updateUserResult is Resource.Error) {
            message = updateUserResult.message ?: "Data failed to update"
            dialogState.show()
        }
    }

    val updateUser: () -> Unit = {
        if (user is Resource.Success) {
            viewModel.updateUser(
                authorization = token,
                name = fullName,
                birthDate = birthDate,
                phoneNumber = whatsappNumber,
                domicile = domicile
            )
        }
    }

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Edit Profile",
                onNavigationClick = navigateUp
            )
        },
        bottomBar = {
            SmallPrimaryButton(
                text = "Save Changes",
                onClick = updateUser,
                enable = buttonEnabled,
                loading = buttonLoading,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp)
                    .navigationBarsPadding()
                    .fillMaxWidth()
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            EditProfileHeader(
                img = img,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Full Name",
                value = fullName,
                onValueChange = viewModel::updateFullName,
                placeholder = "Full Name",
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Email",
                value = email,
                onValueChange = {},
                placeholder = "Email",
                enable = false,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Birth Date",
                value = birthDate,
                onValueChange = viewModel::updateBirthDate,
                placeholder = "Birth Date",
                modifier = Modifier.padding(horizontal = 20.dp),
                trailingIcon = com.eventhngs.ui.R.drawable.ic_date_primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Whatsapp Number",
                value = whatsappNumber,
                onValueChange = viewModel::updateWhatsapp,
                placeholder = "Whatsapp Number",
                type = SmallTextFieldWithLabelType.OUTLINED,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Domicile",
                value = domicile,
                onValueChange = viewModel::updateDomicile,
                placeholder = "Domicile",
                type = SmallTextFieldWithLabelType.OUTLINED,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewEditProfileScreen() {
    EventhngsTheme {
        Surface {
            EditProfileScreen()
        }
    }
}
