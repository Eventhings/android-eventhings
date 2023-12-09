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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_profile.component.EditProfileHeader
import com.eventhngs.ui.component.button.SmallPrimaryButton
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabel
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabelType
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {}
) {

    val scrollState = rememberScrollState()

    val img by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var whatsappNumber by remember { mutableStateOf("") }
    var domicile by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Media Partner",
                onNavigationClick = navigateUp
            )
        },
        bottomBar = {
            SmallPrimaryButton(
                text = "Save Changes",
                onClick = {},
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
                onValueChange = { fullName = it },
                placeholder = "Full Name",
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                enable = false,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Birth Date",
                value = birthDate,
                onValueChange = { birthDate = it },
                placeholder = "Birth Date",
                modifier = Modifier.padding(horizontal = 20.dp),
                trailingIcon = com.eventhngs.ui.R.drawable.ic_date_primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Whatsapp Number",
                value = whatsappNumber,
                onValueChange = { whatsappNumber = it },
                placeholder = "Whatsapp Number",
                type = SmallTextFieldWithLabelType.OUTLINED,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SmallTextFieldWithLabel(
                label = "Domicile",
                value = domicile,
                onValueChange = { domicile = it },
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
