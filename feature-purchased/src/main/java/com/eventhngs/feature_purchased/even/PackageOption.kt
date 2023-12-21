package com.eventhngs.feature_purchased.even

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.common.utils.toRupiah
import com.eventhngs.ui.component.numbertext.TextWithBullet
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun PackageOption(
    modifier: Modifier = Modifier,
    label: String,
    benefits: List<String> = emptyList(),
    price: Double = 0.0,
    quantity: Int = 0,
    onDecreaseClick: (Int) -> Unit = {},
    onIncreaseClick: (Int) -> Unit = {}
) {

    var containerHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    Row(
        modifier = modifier
            .border(
                width = 1.5.dp,
                color = Color(0xFFA1D8D6),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(10.dp)
            .onGloballyPositioned {
                containerHeight = with(density) {
                    it.size.height.toDp()
                }
            }
    ) {
        Spacer(
            modifier = Modifier
                .width(8.dp)
                .height(height = containerHeight)
                .background(
                    color = Color(0xFFA1D8D6),
                    shape = RoundedCornerShape(size = 10.dp)
                )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF2D2D2D)
            )
            Spacer(modifier = Modifier.height(8.dp))
            benefits.forEach { benefit ->
                TextWithBullet(
                    bulletCharacter = "-",
                    text = benefit
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = price.toRupiah(),
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,

                )
                Text(
                    text = "x" + quantity.toString(),
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,


                )

                Text(
                    text = price.toRupiah(),
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF9365CD),
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPackageOption() {
    EventhngsTheme {
        Surface {
            var quantity by remember { mutableIntStateOf(1) }
            PackageOption(
                label = "Paket Bronze",
                benefits = listOf("1x Feed @seputarkampus", "1x IG Story @seputarkampus", "1x IG Story @magangupdate", "1x Twit @seputarkampus"),
                quantity = quantity,
                onDecreaseClick = { quantity = it },
                onIncreaseClick = { quantity = it },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            )
        }
    }
}
