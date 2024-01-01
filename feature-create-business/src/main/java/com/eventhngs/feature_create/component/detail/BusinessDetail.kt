package com.eventhngs.feature_create.component.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_create.domain.BusinessProfile
import com.eventhngs.ui.component.createbusiness.TextFieldBusinessName
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun BusinessDetail(
    modifier: Modifier = Modifier,
    detail: BusinessProfile
) {

    TextFieldBusinessName(
        modifier = Modifier,
        value = detail.value,
        label = detail.label,
        wordLimit = detail.wordLimit,
        onValueChange = {}
    )
}

@Preview
@Composable
fun BusinessDetailPreview() {
    EventhngsTheme {
        Surface {

            val detail = BusinessProfile(
                value = "",
                label = "About",
                wordLimit = "0/1000",
                text = "",
                name = "",
                photo = ""
            )

            BusinessDetail(
                detail = detail,
            )
        }
    }

}