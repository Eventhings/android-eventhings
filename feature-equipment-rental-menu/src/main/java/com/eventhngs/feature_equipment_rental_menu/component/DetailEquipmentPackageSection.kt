package com.eventhngs.feature_equipment_rental_menu.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_equipment_rental_menu.domain.EquipmentPackage
import com.eventhngs.ui.component.event.PackageOption
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun DetailEquipmentPackageSection(
    modifier: Modifier = Modifier,
    packages: List<EquipmentPackage> = emptyList(),
    onDecreaseClick: (EquipmentPackage) -> Unit = {},
    onIncreaseClick: (EquipmentPackage) -> Unit = {},
) {
    Column(modifier = modifier) {
        Text(
            text = "Steps to Book",
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D)
        )
        Spacer(modifier = Modifier.height(8.dp))
        packages.forEach { packageOption ->
            PackageOption(
                label = packageOption.name,
                benefits = packageOption.benefits,
                price = packageOption.price,
                quantity = packageOption.quantity,
                onDecreaseClick = { onDecreaseClick(packageOption.copy(quantity = it)) },
                onIncreaseClick = { onIncreaseClick(packageOption.copy(quantity = it)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun PreviewDetailEquipmentPackageSection() {
    EventhngsTheme {
        Surface {
            val packageOptions = (1..5).map {
                EquipmentPackage(
                    id = it,
                    name = "Paket Bronze",
                    benefits = listOf("1x Feed @seputarkampus", "1x IG Story @seputarkampus", "1x IG Story @magangupdate", "1x Twit @seputarkampus"),
                    price = 50_000.0
                )
            }
            DetailEquipmentPackageSection(
                modifier = Modifier.padding(16.dp),
                packages = packageOptions
            )
        }
    }
}
