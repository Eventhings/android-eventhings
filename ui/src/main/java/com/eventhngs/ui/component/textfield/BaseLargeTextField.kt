package com.eventhngs.ui.component.textfield

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
val largeTextFieldColors @Composable get() =  TextFieldDefaults.outlinedTextFieldColors(
    disabledBorderColor = Color.Transparent,
    unfocusedBorderColor = Color(0xFFA4A4A4),
    focusedBorderColor = Color(0xFF9365CD),
    containerColor = Color.Transparent
)

val largeTextFieldStyle @Composable get() = MaterialTheme.typography.bodyMedium.copy(
    fontWeight = FontWeight.SemiBold,
    color = Color.Black.copy(0.7f),
    fontSize = 14.sp,
)

@ExperimentalMaterial3Api
@Composable
fun BaseLargeTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = largeTextFieldColors,
    textStyle: TextStyle = largeTextFieldStyle
) {
    BaseOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        shape = RoundedCornerShape(12.dp),
        colors = colors,
        singleLine = true,
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
        modifier = modifier.height(50.dp),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        placeholder = {
            if (placeholder.isNotBlank()) {
                Text(
                    text = placeholder,
                    color = Color(0xFFA4A4A4),
                    fontSize = 14.sp,
                )
            }
        }
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewBaseLargeTextField() {
    EventhngsTheme {
        Surface {
            BaseLargeTextField(
                value = "Search",
                onValueChange = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
