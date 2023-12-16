package com.eventhngs.ui.component.textfield

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
@Composable
fun BasePasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    colors: TextFieldColors = largeTextFieldColors,
    textStyle: TextStyle = largeTextFieldStyle
) {

    var passwordVisible by remember { mutableStateOf(false) }
    val visualTransformation = remember(key1 = passwordVisible) {
        if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    }
    val togglePasswordIcon = remember(key1 = passwordVisible) {
        if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
    }

    val togglePasswordVisibility: () -> Unit = {
        passwordVisible = !passwordVisible
    }

    BaseOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        shape = RoundedCornerShape(12.dp),
        colors = colors,
        singleLine = true,
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
        modifier = modifier.height(50.dp),
        trailingIcon = {
            IconButton(onClick = togglePasswordVisibility) {
                Icon(
                    imageVector = togglePasswordIcon,
                    contentDescription = "Toggle password"
                )
            }
        },
        placeholder = {
            if (placeholder.isNotBlank()) {
                Text(
                    text = placeholder,
                    color = Color(0xFFA4A4A4),
                    fontSize = 14.sp,
                )
            }
        },
        visualTransformation = visualTransformation
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewBasePasswordTextField() {
    EventhngsTheme {
        Surface {
            BasePasswordTextField(
                value = "Search",
                onValueChange = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
