package com.eventhngs.feature_profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun EditProfileHeader(
    modifier: Modifier = Modifier,
    img: String,
    onEditProfileClick: () -> Unit = {}
) {
    val imgModifier = Modifier
        .clip(CircleShape)
        .border(1.5.dp, shape = CircleShape, color = Color(0xFF9365CD))
        .size(115.dp)

    Box(modifier = modifier) {
        if (img.isNotEmpty()) {
            AsyncImage(
                model = img,
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = imgModifier
            )
        } else {
            Image(
                painter = painterResource(id = com.eventhngs.ui.R.drawable.img_profile),
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = imgModifier
            )
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(36.dp)
                .background(Color.White)
                .clip(CircleShape)
                .clickable { onEditProfileClick() }
                .padding(4.dp)
                .clip(CircleShape)
                .background(Color(0xFF9365CD))
                .padding(8.dp)
                .align(Alignment.BottomEnd),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = com.eventhngs.ui.R.drawable.ic_small_pen),
                contentDescription = "Edit",
                tint = Color.White
            )
        }

    }
}

@Preview
@Composable
fun PreviewEditProfileHeader() {
    EventhngsTheme {
        Surface {
            EditProfileHeader(
                img = "https://i.pinimg.com/474x/98/51/1e/98511ee98a1930b8938e42caf0904d2d.jpg",
                onEditProfileClick = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
