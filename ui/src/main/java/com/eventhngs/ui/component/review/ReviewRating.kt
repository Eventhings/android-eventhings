package com.eventhngs.ui.component.review

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.eventhngs.ui.R
import com.eventhngs.ui.theme.EventhngsTheme

@Composable
fun ReviewRating(
    modifier: Modifier = Modifier,
    rating: Int = 0
) {
    Row(modifier = modifier) {
        repeat(5) { index ->
            val icon = if (index < rating) R.drawable.ic_star_filled else R.drawable.ic_star_outlined
            Image(painter = painterResource(id = icon), contentDescription = null)
        }
    }
}

@Preview
@Composable
fun PreviewReviewRating() {
    EventhngsTheme {
        Surface {
            ReviewRating(rating = 3)
        }
    }
}
