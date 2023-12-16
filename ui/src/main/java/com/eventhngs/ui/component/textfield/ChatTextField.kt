package com.eventhngs.ui.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.R
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
val chatTextFieldColors @Composable get() =  TextFieldDefaults.outlinedTextFieldColors(
    disabledBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    containerColor = Color(0xFFF5F2F8)
)

val chatTextFieldStyle @Composable get() = MaterialTheme.typography.bodyMedium.copy(
    color = Color(0xFF000000),
    fontSize = 14.sp,
)

@ExperimentalMaterial3Api
@Composable
fun ChatTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    onSendButtonClick: () -> Unit = {},
    colors: TextFieldColors = chatTextFieldColors,
    textStyle: TextStyle = chatTextFieldStyle
) {
    BaseOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        shape = RoundedCornerShape(10.dp),
        colors = colors,
        singleLine = true,
        contentPadding = PaddingValues(start = 12.dp, top = 8.dp, end = 6.dp, bottom = 8.dp),
        modifier = modifier.height(46.dp),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 6.dp))
                    .background(Color(0xFF9365CD))
                    .clickable { onSendButtonClick() }
                    .padding(6.dp)
                    .size(22.dp),
                tint = Color.White
            )
        },
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
fun PreviewChatTextField() {
    EventhngsTheme {
        Surface {
            ChatTextField(
                value = "",
                placeholder = "Write your message",
                onValueChange = {},
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
