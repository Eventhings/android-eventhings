package com.eventhngs.feature_media_partner_menu.component

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
import com.eventhngs.feature_media_partner_menu.domain.MediaPartnerPackage
import com.eventhngs.ui.component.event.PackageOption
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun DetailMediaPartnerPackageSection(
    modifier: Modifier = Modifier,
    packages: List<MediaPartnerPackage> = emptyList(),
    onDecreaseClick: (MediaPartnerPackage) -> Unit = {},
    onIncreaseClick: (MediaPartnerPackage) -> Unit = {},
) {
    Column(
        modifier = modifier
    ) {
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
fun PreviewDetailMediaPartnerPackageSection() {
    EventhngsTheme {
        Surface {
            val packageOptions = (1..5).map {
                MediaPartnerPackage(
                    id = it.toString(),
                    name = "Paket Bronze",
                    benefits = listOf("1x Feed @seputarkampus", "1x IG Story @seputarkampus", "1x IG Story @magangupdate", "1x Twit @seputarkampus"),
                    price = 50_000.0
                )
            }
            DetailMediaPartnerPackageSection(
                modifier = Modifier.padding(16.dp),
                packages = packageOptions
            )
        }
    }
}
