package com.eventhngs.ui.component.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.poppinsFontFamily

@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun SingleChipFilterWithLabel(
    modifier: Modifier = Modifier,
    label: String,
    selectedOption: String,
    onClick: (String) -> Unit = {},
    options: List<String> = emptyList(),
    enabled: Boolean = true,
    type: ChipFilterType = ChipFilterType.MEDIA_PARTNER
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D)
        )
        Spacer(modifier = Modifier.height(8.dp))
        SingleChipFilter(
            selectedOption = selectedOption,
            onClick = onClick,
            options = options,
            enabled = enabled,
            type = type,
            modifier = Modifier.fillMaxWidth()
        )
    }
}