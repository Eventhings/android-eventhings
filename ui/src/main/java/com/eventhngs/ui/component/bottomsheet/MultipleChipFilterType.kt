package com.eventhngs.ui.component.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@Composable
fun MultipleChipFilter(
    modifier: Modifier = Modifier,
    selectedOptions: List<String> = emptyList(),
    onClick: (String) -> Unit = {},
    options: List<String> = emptyList(),
    enabled: Boolean = true,
    type: ChipFilterType = ChipFilterType.MEDIA_PARTNER
) {

    val colors = when (type) {
        ChipFilterType.MEDIA_PARTNER -> mediaPartnerChipColors
        ChipFilterType.SPONSOR -> sponsorChipColors
        ChipFilterType.EQUIPMENT -> equipmentChipColors
    }

    val border = when (type) {
        ChipFilterType.MEDIA_PARTNER -> mediaPartnerChipBorder
        ChipFilterType.SPONSOR -> sponsorChipBorder
        ChipFilterType.EQUIPMENT -> equipmentChipBorder
    }

    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        options.forEach { option ->
            FilterChip(
                selected = selectedOptions.contains(option),
                onClick = { onClick(option) },
                shape = RoundedCornerShape(15.dp),
                colors = colors,
                border = border,
                enabled = enabled,
                label = {
                    Text(
                        text = option,
                        fontSize = 12.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                    )
                },
                modifier = Modifier.heightIn(max = 28.dp)
            )
        }
    }
}

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewMultipleChipFilter() {
    EventhngsTheme {
        Surface {
            val options = listOf("Media Partner", "Sponsor", "Equipment Rental")
            MultipleChipFilter(
                options = options,
                onClick = {},
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
        }
    }
}
