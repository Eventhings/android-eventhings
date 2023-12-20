package com.eventhngs.ui.component.event

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.common.utils.toRatingFormat
import com.eventhngs.common.utils.toRupiah
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType
import com.eventhngs.ui.R
import com.eventhngs.ui.component.text.TextLabel
import com.eventhngs.ui.component.text.TextLabelSize
import com.eventhngs.ui.component.text.generateLabelType
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@ExperimentalLayoutApi
@Composable
fun EventNeedItem(
    modifier: Modifier = Modifier,
    eventNeedItem: EventNeedItem,
    onClick: (EventNeedItem) -> Unit = {}
) {
    val logo = when (eventNeedItem.type) {
        EventNeedItemType.MEDIA_PARTNER -> R.drawable.logo_default_mp
        EventNeedItemType.SPONSOR -> R.drawable.logo_default_sp
        EventNeedItemType.EQUIPMENT -> R.drawable.logo_default_ep
    }
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .border(width = 0.3.dp, color = Color(0xFF4D4D4D), shape = RoundedCornerShape(10.dp))
            .clickable { onClick(eventNeedItem) }
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 5.dp)
    ) {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            repeat(eventNeedItem.label.size) { interation ->
                val label = eventNeedItem.label[interation]
                TextLabel(
                    text = label,
                    textSize = 7.sp,
                    type = label.generateLabelType(),
                    size = TextLabelSize.Small
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = eventNeedItem.logo,
                contentDescription = eventNeedItem.title,
                modifier = Modifier
                    .shadow(
                        elevation = 5.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000)
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .size(50.dp),
                placeholder = painterResource(id = logo),
                error = painterResource(id = logo)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = eventNeedItem.title,
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF2D2D2D),
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = eventNeedItem.price.toRupiah(),
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF9365CD),
            )
            Text(
                text = "⭐ ${eventNeedItem.rating.toRatingFormat()}",
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF787878)
            )
        }
    }
}

@ExperimentalLayoutApi
@Preview
@Composable
fun PreviewEventNeedItem() {
    EventhngsTheme {
        val eventNeedItem = EventNeedItem(
            id = "1",
            logo = "",
            title = "Your Business Name Here",
            label = listOf("Equipment", "Sponsor", "Media Partner", "Photo Booth"),
            price = 100_000.0,
            rating = 4.0
        )
        Surface {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                EventNeedItem(
                    eventNeedItem = eventNeedItem,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                EventNeedItem(
                    eventNeedItem = eventNeedItem,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
