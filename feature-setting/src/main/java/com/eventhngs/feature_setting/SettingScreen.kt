package com.eventhngs.feature_setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier
) {

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = " Setting Screen\nComingSoon"
        )
    }

}

@Preview
@Composable
fun SettingScreenPreview() {
    EventhngsTheme {
        Surface {
            SettingScreen()
        }
    }
}