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
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

enum class ChipFilterType {
    MEDIA_PARTNER, SPONSOR, EQUIPMENT
}

@ExperimentalMaterial3Api
val mediaPartnerChipColors @Composable get() =
    FilterChipDefaults.filterChipColors(
        containerColor = Color.Transparent,
        labelColor = Color(0xFF787878),
        selectedContainerColor = Color(0xFFE55D51),
        selectedLabelColor = Color(0xFFFFFFFF)
    )

@ExperimentalMaterial3Api
val mediaPartnerChipBorder @Composable get() =
    FilterChipDefaults.filterChipBorder(
        borderColor = Color(0xFF787878),
        selectedBorderColor = Color(0xFFE55D51)
    )

@ExperimentalMaterial3Api
val sponsorChipColors @Composable get() =
    FilterChipDefaults.filterChipColors(
        containerColor = Color.Transparent,
        labelColor = Color(0xFF787878),
        selectedContainerColor = Color(0xFF38AF89),
        selectedLabelColor = Color(0xFFFFFFFF)
    )

@ExperimentalMaterial3Api
val sponsorChipBorder @Composable get() =
    FilterChipDefaults.filterChipBorder(
        borderColor = Color(0xFF787878),
        selectedBorderColor = Color(0xFF38AF89)
    )

@ExperimentalMaterial3Api
val equipmentChipColors @Composable get() =
    FilterChipDefaults.filterChipColors(
        containerColor = Color.Transparent,
        labelColor = Color(0xFF787878),
        selectedContainerColor = Color(0xFF4F85CB),
        selectedLabelColor = Color(0xFFFFFFFF)
    )

@ExperimentalMaterial3Api
val equipmentChipBorder @Composable get() =
    FilterChipDefaults.filterChipBorder(
        borderColor = Color(0xFF787878),
        selectedBorderColor = Color(0xFF4F85CB)
    )

@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@Composable
fun SingleChipFilter(
    modifier: Modifier = Modifier,
    selectedOption: String,
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
                selected = selectedOption == option,
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
fun PreviewSingleChipFilter() {
    EventhngsTheme {
        Surface {
            val options = listOf("Media Partner", "Sponsor", "Equipment Rental")
            var selectedOption by remember {
                mutableStateOf(options[0])
            }
            val type = remember(key1 = selectedOption) {
                when (selectedOption) {
                    "Media Partner" -> ChipFilterType.MEDIA_PARTNER
                    "Sponsor" -> ChipFilterType.SPONSOR
                    else -> ChipFilterType.EQUIPMENT
                }
            }
            SingleChipFilter(
                selectedOption = selectedOption,
                options = options,
                onClick = { selectedOption = it },
                type = type,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
        }
    }
}
