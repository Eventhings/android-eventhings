package com.eventhngs.ui.component.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.Grey

@Composable
fun BaseOtpTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String, Boolean) -> Unit,
    otpCount: Int = 4
) {

    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(value, selection = TextRange(value.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onValueChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword, imeAction = ImeAction.Done),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = value
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        },
        singleLine = true,
        maxLines = 1
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> "0"
        index > text.length -> ""
        else -> text[index].toString()
    }
    val color = when {
        isFocused -> MaterialTheme.colorScheme.primary
        else -> Grey
    }
    val borderWidth = when {
        isFocused -> 1.5.dp
        else -> 0.5.dp
    }
    Text(
        modifier = Modifier
            .width(52.dp)
            .height(51.dp)
            .border(
                borderWidth,
                color,
                RoundedCornerShape(12.dp)
            )
            .padding(2.dp),
        text = char,
        style = MaterialTheme.typography.headlineLarge,
        color = color,
        textAlign = TextAlign.Center
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewBaseOtpTextField() {
    EventhngsTheme {

        var value by remember { mutableStateOf("") }

        Surface {
            BaseOtpTextField(
                value = value,
                onValueChange = { newValue, _ -> value = newValue },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
