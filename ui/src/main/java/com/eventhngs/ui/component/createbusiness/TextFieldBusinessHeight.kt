package com.eventhngs.ui.component.createbusiness

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.component.textfield.BaseOutlinedTextField
import com.eventhngs.ui.component.textfield.SmallTextFieldWithLabelType
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TextFieldBusinessHeight(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    label: String,
    wordLimit: String,
    placeholder: String = "",
    singleLine: Boolean = true,
    enable: Boolean = true,
    type: SmallTextFieldWithLabelType = SmallTextFieldWithLabelType.FILLED
) {

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    maxItemsInEachRow = 3
                ) {
                    Text(
                        text = label,
                        fontSize = 12.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF404040),
                    )
                    Text(
                        text = wordLimit,
                        fontSize = 10.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF787878),
                    )

                }
                Spacer(modifier = Modifier.height(2.dp))
                BaseOutlinedTextField(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    value = value,
                    onValueChange = onValueChange,
                    shape = RoundedCornerShape(10.dp),
                    singleLine = singleLine,
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                    enabled = enable,
                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF404040),
                        fontSize = 14.sp,
                    ),
                    placeholder = {
                        if (placeholder.isNotBlank()) {
                            Text(
                                text = placeholder,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFFA4A4A4),
                                fontSize = 14.sp,
                            )
                        }
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun TextFieldBusinessHeightPreview() {
    EventhngsTheme {
        Surface {
            TextFieldBusinessHeight(
                label = "Step 1",
                wordLimit = "0/50",
                value = "",
                onValueChange = {},
                placeholder = "Insert Other Step Here",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                type = SmallTextFieldWithLabelType.OUTLINED,)
        }
    }

}