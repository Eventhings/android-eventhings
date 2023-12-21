package com.eventhngs.feature_media_partner_menu.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
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
import coil.compose.AsyncImage
import com.eventhngs.common.utils.toRupiah
import com.eventhngs.feature_media_partner_menu.domain.MediaPartnerDetail
import com.eventhngs.ui.component.text.TextLabel
import com.eventhngs.ui.component.text.TextLabelSize
import com.eventhngs.ui.component.text.generateLabelType
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@ExperimentalLayoutApi
@Composable
fun DetailMediaPartnerHeader(
    modifier: Modifier = Modifier,
    detail: MediaPartnerDetail,
    onWebsiteClick: (String) -> Unit = {},
    onInstagramClick: (String) -> Unit = {},
    onWhatsappClick: (String) -> Unit = {},
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = detail.logoUrl,
                contentDescription = detail.name,
                contentScale = ContentScale.FillBounds,
                placeholder = painterResource(id = com.eventhngs.ui.R.drawable.ic_menu_media_partner),
                error = painterResource(id = com.eventhngs.ui.R.drawable.ic_menu_media_partner),
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(100.dp)
                    .shadow(8.dp, RoundedCornerShape(10.dp))
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                FlowRow(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    maxItemsInEachRow = 3
                ) {
                    detail.label.forEach { label ->
                        TextLabel(
                            text = label,
                            type = label.generateLabelType(),
                            size = TextLabelSize.Small
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = detail.name,
                    fontSize = 18.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2D2D2D)
                )
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF5F2F8), shape = RoundedCornerShape(size = 10.dp))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "📧 ${detail.email}",
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF404040),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = com.eventhngs.ui.R.drawable.ic_website_primary),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onWebsiteClick(detail.website) }
                    .padding(4.dp)
                    .size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = painterResource(id = com.eventhngs.ui.R.drawable.ic_instagram_primary),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onInstagramClick(detail.instagram) }
                    .padding(4.dp)
                    .size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = painterResource(id = com.eventhngs.ui.R.drawable.ic_whatsapp_primary),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onWhatsappClick(detail.whatsapp) }
                    .padding(4.dp)
                    .size(18.dp)
            )
        }
    }
}

@ExperimentalLayoutApi
@Preview
@Composable
fun PreviewDetailMediaPartnerHeader() {
    EventhngsTheme {
        Surface {
            val detail = MediaPartnerDetail(
                id = "1",
                logoUrl = "",
                name = "Your Business Name Here",
                label = listOf("Equipment", "Sponsor", "Media Partner"),
                price = 100_000.0,
                rating = 4.0,
                email = "marketing@seputarkampus.com"
            )
            DetailMediaPartnerHeader(
                detail = detail,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
