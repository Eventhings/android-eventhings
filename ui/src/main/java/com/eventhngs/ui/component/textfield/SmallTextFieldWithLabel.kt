package com.eventhngs.ui.component.textfield

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.R
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

enum class SmallTextFieldWithLabelType {
    FILLED, OUTLINED
}

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
fun SmallTextFieldWithLabel(
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

    val colors = when (type) {
        SmallTextFieldWithLabelType.FILLED -> SmallTextFieldWithLabelFilledColors
        SmallTextFieldWithLabelType.OUTLINED -> SmallTextFieldWithLabelOutlinedColors
    }

    Column(modifier = modifier) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF404040),
        )
        BaseOutlinedTextField(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(10.dp),
            colors = colors,
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
                        color = Color(0xFF404040),
                        fontSize = 14.sp,
                    )
                }
            },
            trailingIcon = {
                if (trailingIcon != null) {
                    Image(
                        painter = painterResource(id = trailingIcon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewSmallTextFieldWithLabel() {
    EventhngsTheme {
        Surface {
            SmallTextFieldWithLabel(
                label = "Email",
                value = "",
                onValueChange = {},
                placeholder = "Email",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                type = SmallTextFieldWithLabelType.OUTLINED,
                trailingIcon = R.drawable.ic_filter_primary
            )
        }
    }
}
