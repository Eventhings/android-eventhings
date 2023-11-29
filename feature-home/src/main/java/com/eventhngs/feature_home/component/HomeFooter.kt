package com.eventhngs.feature_home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_home.R
import com.eventhngs.ui.component.button.SecondaryButton
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun HomeFooter(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .shadow(
                elevation = 30.dp,
                spotColor = Color(0xFF5D5FEF),
                ambientColor = Color(0xFF5D5FEF)
            )
            .clip(RoundedCornerShape(size = 10.dp))
            .background(color = Color(0xFF5D5FEF))
            .padding(vertical = 18.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_rocket),
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Business Owner?",
                fontSize = 18.sp,
                lineHeight = 30.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Free Upload Event Related Businesses in Eventh!ngs, Can Get 100+ Customers in Average!",
                fontSize = 9.2.sp,
                lineHeight = 15.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(11.dp))
            SecondaryButton(text = "Market Your Business Now")
        }
    }
}

@Preview
@Composable
fun PreviewHomeFooter() {
    EventhngsTheme {
        Surface {
            HomeFooter(
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
