package com.eventhngs.feature_profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_profile.R
import com.eventhngs.feature_profile.domain.ProfileMenu
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun ProfileMenuSection(
    modifier: Modifier = Modifier,
    title: String,
    menuItems: List<ProfileMenu> = emptyList()
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 15.sp,
            lineHeight = 30.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2D2D2D)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 10.dp))
                .border(
                    width = 0.3.dp,
                    color = Color(0xFF4D4D4D),
                    shape = RoundedCornerShape(size = 10.dp)
                ),
            Arrangement.Center
        ) {
            menuItems.forEachIndexed { index, menu ->
                ProfileMenuItem(
                    menu = menu,
                    modifier = Modifier.weight(1f)
                )
                Spacer(
                    modifier = Modifier
                        .height(77.dp)
                        .width(0.3.dp)
                        .background(color = Color(0xFF4D4D4D))
                )
            }
        }
    }
}

@Composable
private fun ProfileMenuItem(
    modifier: Modifier = Modifier,
    menu: ProfileMenu,
    onClick: (ProfileMenu) -> Unit = {}
) {
    Column(
        modifier = modifier
            .clickable { onClick(menu) }
            .padding(top = 11.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = menu.icon),
            contentDescription = stringResource(id = menu.label),
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = menu.label),
            fontSize = 12.5.sp,
            lineHeight = 15.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF404040),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PreviewProfileMenuSection() {
    EventhngsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val menuItems = listOf(
                ProfileMenu(
                    icon = R.drawable.ic_saved,
                    label = R.string.label_saved
                ),
                ProfileMenu(
                    icon = R.drawable.ic_saved,
                    label = R.string.label_saved
                ),
            )
            ProfileMenuSection(
                title = "My Eventh!ngs",
                menuItems = menuItems,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
