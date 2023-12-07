package com.eventhngs.feature_add_business.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_add_business.R
import com.eventhngs.feature_add_business.domain.MarketBusiness
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun MarketBusinessRow(
    modifier: Modifier = Modifier,
    marketBusiness: MarketBusiness
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = marketBusiness.img),
            contentDescription = stringResource(id = marketBusiness.title),
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(5f)) {
            Text(
                text = stringResource(id = marketBusiness.title),
                fontSize = 14.sp,
                lineHeight = 30.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF2D2D2D),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = marketBusiness.description),
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                color = Color(0xFF2D2D2D),
                modifier = Modifier.offset(y = (-4).dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewMarketBusinessRow() {
    EventhngsTheme {
        Surface {
            val marketBusiness = MarketBusiness(
                img = R.drawable.img_ai_power,
                title = R.string.title_ai_power,
                description = R.string.desc_ai_power
            )
            MarketBusinessRow(
                marketBusiness = marketBusiness,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
