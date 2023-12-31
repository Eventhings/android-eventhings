package com.eventhngs.feature_create.component.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
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
import coil.compose.AsyncImage
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType
import com.eventhngs.feature_create.domain.BusinessProfile
import com.eventhngs.ui.R
import com.eventhngs.ui.component.createbusiness.TextFieldBusinessName
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun GeneralBusinessProfile(
    modifier: Modifier = Modifier,
    detail: BusinessProfile,
    eventNeedItem: EventNeedItem,
) {
    val logo = when (eventNeedItem.type) {
        EventNeedItemType.MEDIA_PARTNER -> R.drawable.logo_default_mp
        EventNeedItemType.SPONSOR -> R.drawable.logo_default_sp
        EventNeedItemType.EQUIPMENT -> R.drawable.logo_default_ep
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = detail.text,
            fontWeight = FontWeight.Bold,
        )
        Row (
            modifier = modifier.padding(top = 8.dp)
        ){
            AsyncImage(
                modifier = Modifier
                    .shadow(
                        elevation = 5.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000)
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(end = 15.dp)
                    .height(60.dp)
                    .size(50.dp),
                model = eventNeedItem.logo,
                contentDescription = eventNeedItem.title,
                placeholder = painterResource(id = R.drawable.logo_default_mp),
                error = painterResource(id = R.drawable.logo_default_mp),
            )
            TextFieldBusinessName(
                value = detail.value,
                label = detail.label,
                placeholder = detail.placeholder,
                wordLimit = detail.wordLimit,
                onValueChange = {}
            )
        }

    }

}

@Preview
@Composable
fun GeneralBusinessProfilePreview() {
    EventhngsTheme {
        val eventNeedItem = EventNeedItem(
            logo = "",
        )
        val detail = BusinessProfile(
            value = "",
            text = "Business Profile",
            label = "Business Name",
            wordLimit = "0/42",
            placeholder = "Input name here",
            name = "",
            description = "",
            photo = ""
        )
        Surface {
            Row(
            ) {
                GeneralBusinessProfile(
                    eventNeedItem = eventNeedItem,
                    detail = detail
                )
            }
        }
    }
    
}