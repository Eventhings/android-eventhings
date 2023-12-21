package com.eventhngs.feature_profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.feature_profile.domain.Profile
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    profile: Profile,
    onEditProfileClick: () -> Unit = {},
    onSettingClick: () -> Unit = {},
) {
    val editProfileText = buildAnnotatedString {
        withStyle(
            SpanStyle(
                fontSize = 11.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF9365CD)
            )
        ) {
            append("Edit Profile >")

        }
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = profile.photo,
            contentDescription = profile.name,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = com.eventhngs.ui.R.drawable.img_profile),
            error = painterResource(id = com.eventhngs.ui.R.drawable.img_profile),
            modifier = Modifier
                .clip(CircleShape)
                .border(width = 1.dp, color = Color(0xFF9365CD), shape = CircleShape)
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = profile.name,
                fontSize = 14.5.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF2D2D2D)
            )
            ClickableText(
                text = editProfileText,
                onClick = { onEditProfileClick() }
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = painterResource(id = com.eventhngs.ui.R.drawable.ic_settings), contentDescription = "Settings")
        }
    }
}

@Preview
@Composable
fun PreviewProfileHeader() {
    EventhngsTheme {
        Surface {
            val profile = Profile(
                photo = "https://i.pinimg.com/474x/98/51/1e/98511ee98a1930b8938e42caf0904d2d.jpg",
                name = "Abdul Hafiz Ramadan"
            )
            ProfileHeader(
                profile = profile,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
