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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_media_partner_menu.domain.MediaPartnerDetail
import com.eventhngs.ui.component.numbertext.TextWithBullet
import com.eventhngs.ui.component.numbertext.TextWithNumber
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun DetailMediaPartnerInformationSection(
    modifier: Modifier = Modifier,
    detail: MediaPartnerDetail
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
        repeat(detail.stepsToBook.size) { iteration ->
            TextWithNumber(number = iteration + 1, text = detail.stepsToBook[iteration])
            Spacer(modifier = Modifier.height(4.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Steps After Book",
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D)
        )
        Spacer(modifier = Modifier.height(8.dp))
        repeat(detail.stepsAfterBook.size) { iteration ->
            TextWithNumber(number = iteration + 1, text = detail.stepsAfterBook[iteration])
            Spacer(modifier = Modifier.height(4.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "About",
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = detail.description,
            fontSize = 12.4.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight(400),
            color = Color(0xFF404040),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Value",
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D)
        )
        Spacer(modifier = Modifier.height(8.dp))
        repeat(detail.value.size) { iteration ->
            TextWithBullet(text = detail.value[iteration])
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
fun PreviewDetailMediaPartnerInformationSection() {
    EventhngsTheme {
        Surface {
            val detail = MediaPartnerDetail(
                stepsToBook = listOf(
                    "Choose package",
                    "Add quantity",
                    "Invoice and payment",
                    "Send poster and caption"
                ),
                stepsAfterBook = listOf(
                    "Wait for the upload schedule and stay tune at our social media"
                ),
                description = "MagangUpdate Network is an informative and educative media about the world of internships. This media has been around since 2012 and has experience in collaborating with various event activities and companies.",
                value = listOf(
                    "Top 1 Platform Sharing Internships and Jobs Information in Indonesia",
                    "We have had and maintained relationships with 10+ Universities, 40+ Enterprise & Start-up, and 1000+ Event Partners"
                )
            )
            DetailMediaPartnerInformationSection(
                detail = detail,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
