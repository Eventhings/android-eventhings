package com.eventhngs.feature_create.component.general

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.eventhngs.ui.component.createbusiness.TextFieldCategory
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralBasicInformation(
    modifier: Modifier = Modifier,
) {

    Column (modifier = modifier){
        Text(
            text = "Basic Information",
            fontWeight = FontWeight.SemiBold,
            fontFamily = poppinsFontFamily,
            color = Color.Black,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldCategory(
            label = "Category",
            value = " ",
            onValueChange = {},
            placeholder = "Select One",
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldCategory(
            label = "Subcategory",
            value = " ",
            onValueChange = {},
            placeholder = "Select One"
        )

    }
}

@Preview
@Composable
fun GeneralBasicInformationPreview() {
    EventhngsTheme {
        Surface {
            GeneralBasicInformation()
        }
    }

}