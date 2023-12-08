package com.eventhngs.feature_chat.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.ui.component.searchbar.SmallSearchBar
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.R as RUi

@ExperimentalMaterial3Api
@Composable
fun ChatSearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    onAddChatClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SmallSearchBar(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(14.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 10.dp))
                .size(40.dp)
                .background(color = Color(0xFFF5F2F8), shape = RoundedCornerShape(size = 10.dp))
                .clickable { onAddChatClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = RUi.drawable.ic_add_primary),
                contentDescription = "Add chat"
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewChatSearchBar() {
    EventhngsTheme {
        Surface {
            ChatSearchBar(
                value = "",
                onValueChange = {},
                placeholder = "Search"
            )
        }
    }
}
