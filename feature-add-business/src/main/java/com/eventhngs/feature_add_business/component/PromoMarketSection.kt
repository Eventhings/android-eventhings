package com.eventhngs.feature_add_business.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.common.utils.toRupiah
import com.eventhngs.ui.component.button.SmallPrimaryButton
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun PromoMarketSection(
    modifier: Modifier = Modifier,
    promoDate: String,
    price: Double,
    onMarketBusinessClicked: () -> Unit
) {
    val priceString = buildAnnotatedString {
        withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) {
            append(price.toRupiah())
            append(" ")
        }
        withStyle(SpanStyle(color = Color(0xFF9365CD))) {
            append("FREE!")
        }
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 0.3.dp,
                color = Color(0xFF4D4D4D),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(vertical = 10.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Limited promo until $promoDate",
                fontSize = 11.sp,
                lineHeight = 16.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF2D2D2D)
            )
            Text(
                text = priceString,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
            )
        }
        SmallPrimaryButton(
            text = "Market Business",
            onClick = onMarketBusinessClicked
        )
    }
}

@Preview
@Composable
fun PreviewPromoMarketSection() {
    EventhngsTheme {
        Surface {
            PromoMarketSection(
                modifier = Modifier.padding(16.dp),
                promoDate = "Feb 30th, 2024",
                price = 199_000.0,
                onMarketBusinessClicked = {}
            )
        }
    }
}
