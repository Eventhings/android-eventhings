package com.eventhngs.feature_create.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_create.component.DetailBottomNavigation
import com.eventhngs.feature_create.component.detail.DetailStepToOrder
import com.eventhngs.ui.component.createbusiness.TextFieldBusinessHeight
import com.eventhngs.ui.component.createbusiness.TextFieldBusinessName
import com.eventhngs.ui.component.createbusiness.TextFieldPrice
import com.eventhngs.ui.component.text.PrimaryText
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePackageScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {}
) {

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
                .padding(paddingValues)
        ){
            item {
                DetailStepToOrder(
                    title = "Package Information",
                    description = "e.g. media partner (Bronze, Silver, Gold), equipment rental (Photobooth Mirror, Photobox, Video Booth)"

                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldBusinessName(
                    onValueChange = {},
                    value = "",
                    label = "Name",
                    wordLimit = "0/50",
                    placeholder = "Insert package name here"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldBusinessHeight(
                    onValueChange = {},
                    value = "",
                    label = "Description",
                    wordLimit = "0/1000",
                    placeholder = "Describe your package here (e.g.\n" +
                            "- 1x Feed @seputarkampus\n" +
                            "- 1x IG Story @seputarkampus\n" +
                            "- 1x IG Story @magangupdate\n" +
                            "- 1x Twit @seputarkampus)"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldPrice(
                    onValueChange = {},
                    value = "",
                    label = "Price (Rp)",
                    placeholder = "Input price here",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                PrimaryText(
                    text = "+ ADD OTHER PACKAGE",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF9365CD),
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldBusinessName(
                    onValueChange = {},
                    value = "",
                    label = "Name",
                    wordLimit = "0/50",
                    placeholder = "Insert package name here"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldBusinessHeight(
                    onValueChange = {},
                    value = "",
                    label = "Description",
                    wordLimit = "0/1000",
                    placeholder = "Describe your package here (e.g.\n" +
                            "- 1x Feed @seputarkampus\n" +
                            "- 1x IG Story @seputarkampus\n" +
                            "- 1x IG Story @magangupdate\n" +
                            "- 1x Twit @seputarkampus)"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldPrice(
                    onValueChange = {},
                    value = "",
                    label = "Price (Rp)",
                    placeholder = "Input price here",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
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
fun CreatePackageScreenPreview() {
    EventhngsTheme {
        Surface {
            CreatePackageScreen()
        }
    }
}