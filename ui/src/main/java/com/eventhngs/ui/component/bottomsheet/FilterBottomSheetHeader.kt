package com.eventhngs.ui.component.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.component.button.BaseClickableText
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily
@Composable
fun FilterBottomSheetHeader(
    modifier: Modifier = Modifier,
    title: String = "Filter",
    onResetClick: () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            lineHeight = 30.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D)
        )
        BaseClickableText(
            text = "Reset All",
            onClick = onResetClick,
            textStyle = TextStyle(
                fontSize = 15.sp,
                lineHeight = 30.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF9365CD)
            )
        )
    }
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewFilterBottomSheet() {
    EventhngsTheme {
        Surface {
        }
    }
}
