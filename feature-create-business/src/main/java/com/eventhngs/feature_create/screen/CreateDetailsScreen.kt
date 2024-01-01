package com.eventhngs.feature_create.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_create.component.DetailBottomNavigation
import com.eventhngs.feature_create.component.detail.DetailStepToOrder
import com.eventhngs.ui.component.createbusiness.TextFieldBusinessHeight
import com.eventhngs.ui.component.createbusiness.TextFieldBusinessName
import com.eventhngs.ui.component.tabbar.TabBarCreateBusiness
import com.eventhngs.ui.component.text.PrimaryText
import com.eventhngs.ui.component.textfield.SmallTextFieldWithDeleteIcon
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabelType
import com.eventhngs.ui.component.topappbar.DetailTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateDetailScreen(
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
                .padding(start = 20.dp, end = 20.dp)
                .padding(paddingValues),
        ){
            item {
                TabBarCreateBusiness(
                    onPurchasedClick = {}
                )
            }
            item {
                DetailStepToOrder(
                    title = "Step to Order",
                    description = "Give information to customers about what to prepare prior to service order"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldBusinessName(
                    label = "Step 1",
                    wordLimit = "0/50",
                    value = "",
                    onValueChange = {},
                    placeholder = "Insert Other Step Here",
                    modifier = Modifier
                        .fillMaxWidth(),
                    type = SmallTextFieldWithLabelType.OUTLINED
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                SmallTextFieldWithDeleteIcon(
                    onValueChange = {} ,
                    value = "",
                    label = "Step 2",
                    wordLimit = "0/50",
                    placeholder = "Insert other step here"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                PrimaryText(
                    text = "+ ADD OTHER STEP",
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color(0xFF9365CD)
                )
            }
            item { Spacer(modifier = Modifier.height(15.dp)) }
            item {
                DetailStepToOrder(
                    title = "Steps after other",
                    description = "what should my customers do after payment?"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldBusinessName(
                    onValueChange = {},
                    value = "",
                    label = "Step 1",
                    wordLimit = "0/50",
                    placeholder = "Insert step adter order here"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                PrimaryText(
                    text = "+ ADD OTHER STEP",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF9365CD)
                )
            }
            item { Spacer(modifier = Modifier.height(15.dp)) }
            item {
                Text(
                    text = "Business Detail",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppinsFontFamily,
                    color = Color(0xFF2D2D2D)
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TextFieldBusinessHeight(
                    onValueChange = {},
                    value = "",
                    label = "About",
                    wordLimit = "0/1000",
                    placeholder = "Describe your business here (what is your business do? what is your business purposes?  anything to attract more customers)"

                )
            }
            item {
                TextFieldBusinessName(
                    onValueChange = {},
                    value = "",
                    label = "Value",
                    wordLimit = "0/50",
                    placeholder = "Insert your business strength here"
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                PrimaryText(
                    text = "+ ADD OTHER VALUE",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF9365CD)
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item{
                SmallTextFieldWithDeleteIcon(
                    onValueChange = {} ,
                    value = "",
                    label = "",
                    wordLimit = "0/50",
                    placeholder = "Insert other business strength here"
                )
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
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
fun CreateDetailScreenPreview() {
    EventhngsTheme {
        Surface {
            CreateDetailScreen()
        }
    }

}