package com.eventhngs.feature_profile.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_profile.R
import com.eventhngs.feature_profile.component.ProfileHeader
import com.eventhngs.feature_profile.component.ProfileMenuSection
import com.eventhngs.feature_profile.domain.Profile
import com.eventhngs.feature_profile.domain.ProfileMenu
import com.eventhngs.ui.component.button.SmallPrimaryButton
import com.eventhngs.ui.component.topappbar.BaseTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigateToEditProfileScreen: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val profile = Profile(
        photo = "https://i.pinimg.com/474x/98/51/1e/98511ee98a1930b8938e42caf0904d2d.jpg",
        name = "Abdul Hafiz Ramadan"
    )
    val myEventhingsMenus = listOf(
        ProfileMenu(
            icon = R.drawable.ic_saved,
            label = R.string.label_saved
        )
    )
    val uploadedBusinessMenus = listOf(
        ProfileMenu(
            icon = R.drawable.ic_draft,
            label = R.string.label_draft
        ),
        ProfileMenu(
            icon = R.drawable.ic_active,
            label = R.string.label_active
        ),
        ProfileMenu(
            icon = R.drawable.ic_archive,
            label = R.string.label_archive
        ),
    )
    
    Scaffold(
        topBar = {
            BaseTopAppBar(title = "Profile")
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            ProfileHeader(
                profile = profile,
                modifier = Modifier.padding(horizontal = 20.dp),
                onEditProfileClick = navigateToEditProfileScreen
            )
            Spacer(modifier = Modifier.height(16.dp))
            ProfileMenuSection(
                title = "My Eventh!ngs",
                menuItems = myEventhingsMenus,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ProfileMenuSection(
                title = "Uploaded Businesses",
                menuItems = uploadedBusinessMenus,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            SmallPrimaryButton(
                text = "Upload Business",
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewProfileScreen() {
    EventhngsTheme {
        Surface {
            ProfileScreen()
        }
    }
}
