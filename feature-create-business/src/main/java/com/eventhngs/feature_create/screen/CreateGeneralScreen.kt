package com.eventhngs.feature_create.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.feature_create.R
import com.eventhngs.feature_create.component.DetailBottomNavigation
import com.eventhngs.feature_create.component.general.GeneralBasicInformation
import com.eventhngs.feature_create.component.general.GeneralBusinessProfile
import com.eventhngs.feature_create.component.general.GeneralSocialMedia
import com.eventhngs.feature_create.domain.BusinessProfile
import com.eventhngs.ui.component.createbusiness.TextFieldBusinessName
import com.eventhngs.ui.component.createbusiness.TextFieldPrice
import com.eventhngs.ui.component.tabbar.TabBarCreateBusiness
import com.eventhngs.ui.component.textfield.BaseLargeTextField
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabel
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme


@OptIn(ExperimentalMaterial3Api::class)
@androidx.compose.runtime.Composable
fun CreatGeneralScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
) {
    var email by remember {
        mutableStateOf("")
    }
    var website by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Create Business",
                onNavigationClick = navigateUp
            )
        }
    ) {paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                TabBarCreateBusiness(
                    onPurchasedClick = {}
                )
            }
            item {
                GeneralBasicInformation()
            }
            item {
                val detail = BusinessProfile(
                    value = "",
                    text = "Business Profile",
                    label = "Business Name",
                    wordLimit = "0/42",
                    placeholder = "Input name here",
                    name = "",
                    description = "",
                    photo = ""
                )
                GeneralBusinessProfile(
                    detail = detail,
                    eventNeedItem = EventNeedItem()
                )
            }
            item {
                BaseLargeTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {  },
                    label = stringResource(R.string.business_email),
                    placeholder = "Input email here",
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                BaseLargeTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = {  },
                    label = stringResource(R.string.confirm_email),
                    placeholder = "Retype email here",
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                GeneralSocialMedia()
            }
            item {
                TextFieldPrice(
                    onValueChange = {},
                    value = "+62",
                    label = "WhatsApp Phone Number",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = "81234567890"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldBusinessName(
                    modifier = Modifier.fillMaxWidth(),
                    value = "https://" ,
                    label = "Website",
                    onValueChange = {},
                    placeholder = "www.example.com",
                    wordLimit = ""
                )
            }
            item {
                DetailBottomNavigation(
                    text = "",
                    onButtonClick = {},
                    onSaveClick = {}
                )
            }

        }

    }
}

@Preview
@Composable
fun CreateGeneralScreenPreview() {
    EventhngsTheme {
        Surface {
            CreatGeneralScreen()
        }
    }
    
}