package com.eventhngs.ui.component.createbusiness

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.R
import com.eventhngs.ui.component.textfield.BaseOutlinedTextField
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabelType
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily


@ExperimentalMaterial3Api
private val SmallTextFieldWithLabelFilledColors @Composable get() = TextFieldDefaults.outlinedTextFieldColors(
    disabledBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    focusedBorderColor = Color(0xFF9365CD),
    containerColor = Color(0xFFF5F2F8)
)

@ExperimentalMaterial3Api
private val SmallTextFieldWithLabelOutlinedColors @Composable get() = TextFieldDefaults.outlinedTextFieldColors(
    unfocusedBorderColor = Color(0xFFA4A4A4),
    containerColor = Color.Transparent
)

@ExperimentalMaterial3Api
@Composable
fun TextFieldCategory(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    singleLine: Boolean = true,
    @DrawableRes
    trailingIcon: Int? = null,
    enable: Boolean = true,
    type: SmallTextFieldWithLabelType = SmallTextFieldWithLabelType.FILLED
) {

    var isExpanded by remember{ mutableStateOf(false) }
    var gender by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ){
        Text(
            text = label,
            fontSize = 12.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF404040),
        )
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it}
        ) {

            BaseOutlinedTextField(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(),
                singleLine = singleLine,
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                enabled = enable,
                value = gender,
                onValueChange = {},
                readOnly = true,
                shape = RoundedCornerShape(10.dp),
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
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF404040),
                    fontSize = 14.sp,
                ),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = "male")
                    },
                    onClick = {
                        gender = "male"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(text = "female")
                    },
                    onClick = {
                        gender = "female"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(text = "other")
                    },
                    onClick = {
                        gender = "other"
                        isExpanded = false
                    }
                )


            }
        }

    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewTextFieldCategory() {
    EventhngsTheme {
        Surface {
            TextFieldCategory(
                label = "Category",
                value = " ",
                onValueChange = {},
                placeholder = "Select One",
                modifier = Modifier
                    .fillMaxSize(),
                type = SmallTextFieldWithLabelType.OUTLINED,
                trailingIcon = R.drawable.ic_drop_down
            )
        }
    }
}