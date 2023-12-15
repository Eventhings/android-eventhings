package com.eventhngs.ui.component.event

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun CounterButton(
    modifier: Modifier = Modifier,
    count: Int = 0,
    onDecreaseClick: (Int) -> Unit = {},
    onIncreaseClick: (Int) -> Unit = {}
) {
    val decreaseEnable = remember(key1 = count) {
        count > 0
    }
    val decreaseColor = remember(key1 = count) {
        if (count > 0) Color(0xFF404040) else Color(0xFFA0A0A0)
    }
    Row(
        modifier = modifier
            .border(
                width = 1.5.dp,
                color = Color(0xFF9365CD),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .height(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "-",
            fontSize = 12.4.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            color = decreaseColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
                .size(20.dp)
                .offset(x = 1.dp)
                .clickable(enabled = decreaseEnable) { onDecreaseClick(count - 1) }

        )
        Spacer(
            modifier = Modifier
                .width(1.5.dp)
                .fillMaxHeight()
                .background(Color(0xFF9365CD))
        )
        Text(
            text = count.toString(),
            fontSize = 12.4.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF404040),
            textAlign = TextAlign.Center,
            modifier = Modifier.size(20.dp)
        )
        Spacer(
            modifier = Modifier
                .width(1.5.dp)
                .fillMaxHeight()
                .background(Color(0xFF9365CD))
        )
        Text(
            text = "+",
            fontSize = 12.4.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF404040),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
                .size(20.dp)
                .offset(x = (-1).dp)
                .clickable { onIncreaseClick(count + 1) }
        )
    }
}

@Preview
@Composable
fun PreviewCounterButton() {
    EventhngsTheme {
        Surface {
            var counter by remember { mutableIntStateOf(1) }
            CounterButton(
                modifier = Modifier.padding(16.dp),
                count = counter,
                onDecreaseClick = { counter = it },
                onIncreaseClick = { counter = it }
            )
        }
    }
}
