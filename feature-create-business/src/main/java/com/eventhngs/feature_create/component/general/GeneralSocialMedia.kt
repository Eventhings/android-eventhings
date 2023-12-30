package com.eventhngs.feature_create.component.general

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.ui.component.checkbox.CheckBoxInstagram
import com.eventhngs.ui.component.checkbox.CheckBoxWhatapp
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun GeneralSocialMedia(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Business Social Media",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        Text(
            text = "Choose at least one of additional contact detail below",
            fontFamily = poppinsFontFamily,
            fontSize = 12.sp
        )

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            CheckBoxWhatapp(
                onClick = {}
            )
            CheckBoxInstagram(
                onClick = {}
            )

        }
    }



}

@Preview
@Composable
fun GeneralSocialMediaPreview() {
    EventhngsTheme {
        Surface {
            GeneralSocialMedia()
        }
    }

}