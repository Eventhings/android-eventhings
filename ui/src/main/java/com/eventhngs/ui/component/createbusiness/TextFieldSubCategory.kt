package com.eventhngs.ui.component.createbusiness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.R
import com.eventhngs.ui.component.textfield.BaseOutlinedTextField
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabelType
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldSubCategory(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    singleLine: Boolean = true,
    trailingIcon: Int? = null,
    enable: Boolean = true,
    type: SmallTextFieldWithLabelType = SmallTextFieldWithLabelType.FILLED
) {
    var isExpanded by remember { mutableStateOf(false) }
    var subCategory by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF404040),
        )
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            BaseOutlinedTextField(
                value = subCategory,
                onValueChange = {},
                readOnly = true,
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                placeholder = {
                    if (placeholder.isNotBlank()) {
                        Text(
                            text = placeholder,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF404040),
                            fontSize = 14.sp,
                        )
                    }
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isExpanded ,
                onDismissRequest = { isExpanded = false })
            {
                DropdownMenuItem(
                    text = {
                           Text(text = "Photo Booth")
                    },
                    onClick = {
                        subCategory = "Photo Booth"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                           Text(text = "Lighting")
                    },
                    onClick = {
                        subCategory = "Lighting"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                           Text(text = "Tent")
                    },
                    onClick = {
                        subCategory = "Tent"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                           Text(text = "Bouquet")
                    },
                    onClick = {
                        subCategory = "Bouquet"
                        isExpanded = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun TextFieldSubCategoryPreview() {
    EventhngsTheme {
        Surface {
            TextFieldSubCategory(
                label = "SubCategory",
                value = " ",
                onValueChange = {},
                placeholder = "Select One",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                type = SmallTextFieldWithLabelType.OUTLINED,
                trailingIcon = R.drawable.ic_drop_down
            )
        }
    }

}