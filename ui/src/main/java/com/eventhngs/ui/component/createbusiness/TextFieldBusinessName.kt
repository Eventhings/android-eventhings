package com.eventhngs.ui.component.createbusiness

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.common.utils.toRatingFormat
import com.eventhngs.common.utils.toRupiah
import com.eventhngs.ui.R
import com.eventhngs.ui.component.textfield.BaseLargeTextField
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldBusinessName(
    modifier: Modifier = Modifier,
    value: String,
) {
    Column(
        modifier = modifier,
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "Business Name",
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "0/42",
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF787878)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            BaseLargeTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = { },
                label = "label",
                placeholder = "Input Name Here",
            )
        }
    }
}


/*
Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Business Name",
            fontSize = 12.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = "0/42",
            fontSize = 12.sp,
            lineHeight = 20.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight(500),
            color = Color(0xFF787878)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = modifier) {
            BaseLargeTextField(
                modifier = Modifier.fillMaxWidth(),
                value = " ",
                onValueChange = {  },
                placeholder = "Input Name Here",
            )

        }
    }
 */

@Preview
@Composable
fun TextFieldBusinessNamePreview() {
    EventhngsTheme {
        Surface {
            TextFieldBusinessName(
                value = ""
            )
        }
    }
}