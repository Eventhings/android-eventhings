package com.eventhngs.feature_create.component.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_create.domain.BusinessProfile
import com.eventhngs.ui.component.text.BodyText
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun DetailStepToOrder(
    modifier: Modifier = Modifier,
    title: String,
    description: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = title,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        BodyText(
            text = description,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF787878)
        )

    }

}

@Preview
@Composable
fun DetailStepToOrderPreview() {
    EventhngsTheme {
        Surface {
            DetailStepToOrder(
                title = "Step to Order",
                description = "Give information to customers about what to prepare prior to service order"
            )
        }
    }

}