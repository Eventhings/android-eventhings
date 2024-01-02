package com.eventhngs.ui.component.checkbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.R
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun CheckBoxInstagram(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {

    val checkstate = remember { mutableStateOf(true) }
    Row(
        modifier = modifier
            .border(
                width = 0.5.dp,
                color = Color(0xFFA4A4A4),
                shape = RoundedCornerShape(size = 12.dp)
            )
            .height(51.dp)
            .clip(RoundedCornerShape(size = 12.dp))
            .padding(10.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_instagram),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            lineHeight = 25.sp,
            fontFamily = poppinsFontFamily,
            color = Color(0xFF4D4D4D)
        )
        var isChecked by remember{ mutableStateOf(false) }
        Checkbox(checked = isChecked, onCheckedChange = {isChecked = it})


    }

    /*
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(20.dp)
        )

        val socialMedia = arrayListOf("Whatapps","Instagram")
        socialMedia.forEach{options : String ->
            var isChecked by remember{ mutableStateOf(false) }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(options)
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {isChecked = it}
                )
            }
        }

     */

    /*
    Checkbox(
        checked = checkstate.value,
        onCheckedChange = {checkstate.value = it},
        modifier = Modifier.scale(3f),
        colors = CheckboxDefaults.colors(
            checkmarkColor = Color.White,
            checkedColor = Color(0xFF9365CD)
        )
    )



}

     */
}

@Preview
@Composable
fun CheckBoxInstagramPreview() {
    EventhngsTheme {
        CheckBoxInstagram(
            text = "Instagram"
        )
    }

}