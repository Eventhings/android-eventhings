package com.eventhngs.feature_home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.common.utils.toRupiah
import com.eventhngs.feature_home.domain.CarouselItem
import com.eventhngs.ui.component.text.TextLabel
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun HomeCarouselItem(
    modifier: Modifier = Modifier,
    carouselItem: CarouselItem,
    onClick: (CarouselItem) -> Unit = {}
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick(carouselItem) }
            .shadow(
                elevation = 30.dp,
                spotColor = MaterialTheme.colorScheme.primary,
                ambientColor = MaterialTheme.colorScheme.primary
            )
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(
                start = 20.dp,
                top = 20.dp,
                end = 15.dp,
                bottom = 20.dp
            )
    ) {
        AsyncImage(
            model = carouselItem.logo,
            contentDescription = carouselItem.label,
            modifier = Modifier
                .size(95.dp)
                .clip(RoundedCornerShape(10.dp))
                .shadow(elevation = 30.dp, spotColor = Color.White, ambientColor = Color.White)
                .background(Color.White)
        )
        Spacer(modifier = Modifier.width(14.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            TextLabel(text = carouselItem.label)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = carouselItem.title,
                fontSize = 15.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.align(Alignment.    Bottom)
        ) {
            Text(
                text = "⭐ ${carouselItem.rating}",
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.White,
            )
            Text(
                text = carouselItem.price.toRupiah(),
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Right,
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeCarouselItem() {
    EventhngsTheme {
        val carouselItem = CarouselItem(
            id = 1,
            logo = "",
            title = "Your Business Name Here",
            label = "Eventh!ngs of the Day!",
            price = 100_000.0,
            rating = 4.0
        )

        Surface {
            Column {
                HomeCarouselItem(
                    carouselItem = carouselItem,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}
