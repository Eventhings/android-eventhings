package com.eventhngs.feature_home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.R
import com.eventhngs.feature_home.domain.MenuItem
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    menu: MenuItem,
    onClick: (MenuItem) -> Unit = {}
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .clickable { onClick(menu) }
                .background(Color(0xFFF5F2F8))
                .size(50.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = menu.icon),
                contentDescription = stringResource(id = menu.label),
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(id = menu.label),
            fontSize = 10.sp,
            lineHeight = 30.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Preview
@Composable
fun PreviewMenuItem() {
    EventhngsTheme {
        val menu = MenuItem(
            icon = R.drawable.ic_menu_all,
            label = R.string.label_all
        )
        Surface {
            MenuItem(
                menu = menu,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
