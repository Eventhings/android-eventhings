package com.eventhngs.ui.component.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.eventhngs.ui.R
import com.eventhngs.ui.component.button.SmallPrimaryButton
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun DetailBottomNavigation(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .background(Color.White)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlineIconButton(
            icon = R.drawable.ic_share_primary,
            onClick = onShareClick
        )
        OutlineIconButton(
            icon = R.drawable.ic_save_primary,
            onClick = onSaveClick
        )
        SmallPrimaryButton(
            text = text,
            onClick = onButtonClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun OutlineIconButton(
    modifier: Modifier = Modifier,
    @DrawableRes
    icon: Int,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .border(
                width = 1.5.dp,
                color = Color(0xFF9365CD),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .size(39.dp),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(27.dp)
        )
    }
}

@Preview
@Composable
fun PreviewDetailBottomNavigation() {
    EventhngsTheme {
        Surface {
            DetailBottomNavigation(
                text = "Choose Package",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
