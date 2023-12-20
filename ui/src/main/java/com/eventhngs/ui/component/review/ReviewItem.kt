package com.eventhngs.ui.component.review

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eventhngs.domain.model.ReviewsItem
import com.eventhngs.ui.component.text.TextWithLikeIcon
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.poppinsFontFamily

@Composable
fun ReviewItem(
    modifier: Modifier = Modifier,
    reviewItem: ReviewsItem,
    onLikeClick: (ReviewsItem) -> Unit = {}
) {
    Row(modifier = modifier) {
        AsyncImage(
            model = "",
            contentDescription = reviewItem.userDetail.email,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .border(width = 1.dp, color = Color(0xFF9365CD), shape = CircleShape)
                .size(35.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = reviewItem.userDetail.email,
                    fontSize = 10.sp,
                    lineHeight = 15.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF2D2D2D)
                )
                TextWithLikeIcon(
                    like = 0,
                    isLiked = false,
                    onClick = { onLikeClick(reviewItem) }
                )
            }
            ReviewRating(rating = reviewItem.rating)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = reviewItem.review,
                fontSize = 10.sp,
                lineHeight = 15.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(500),
                color = Color(0xFF2D2D2D),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview
@Composable
fun PreviewReviewItem() {
    EventhngsTheme {
        Surface {
            val review = ReviewsItem(
                id = "51c1a7c3-3b89-412a-9e74-89321dbb1008",
                rating = 5,
                review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque pharetra condimentum lacus id varius. Donec consequat arcu mi, nec varius felis bibendum ut. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."
            )
            ReviewItem(
                reviewItem = review,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
