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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eventhngs.domain.model.Resource
import com.eventhngs.feature_profile.R
import com.eventhngs.feature_profile.component.ProfileHeader
import com.eventhngs.feature_profile.component.ProfileMenuSection
import com.eventhngs.feature_profile.domain.Profile
import com.eventhngs.feature_profile.domain.ProfileMenu
import com.eventhngs.ui.component.button.SmallPrimaryButton
import com.eventhngs.ui.component.topappbar.BaseTopAppBar
import com.eventhngs.ui.theme.EventhngsTheme
import org.koin.androidx.compose.koinViewModel

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = koinViewModel(),
    navigateToEditProfileScreen: (String) -> Unit = {}
) {
    val scrollState = rememberScrollState()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val userPreference = uiState.userPreference
    val refreshToken = uiState.refreshToken
    val user = uiState.user

    var profile by remember { mutableStateOf(Profile()) }

    LaunchedEffect(key1 = Unit) {
        viewModel.getUserPreference()
    }

    LaunchedEffect(key1 = userPreference) {
        if (userPreference.refreshToken.isNotEmpty() && refreshToken !is Resource.Success) {
            viewModel.getRefreshToken(userPreference.refreshToken)
        }
    }

    LaunchedEffect(key1 = refreshToken) {
        if (refreshToken is Resource.Success) {
            viewModel.getUserLogging(accessToken = refreshToken.data.accessToken)
            viewModel.updateAccessToken(accessToken = refreshToken.data.accessToken)
        }
    }

    LaunchedEffect(key1 = user) {
        if (user is Resource.Success) {
            val data = user.data
            profile = Profile(
                photo = data.photoUrl,
                name = data.displayName
            )
        }
    }

    val onEditProfileClick: () -> Unit = {
        if (refreshToken is Resource.Success && user is Resource.Success) {
            navigateToEditProfileScreen(refreshToken.data.accessToken)
        }
    }

//    val balance by remember { mutableDoubleStateOf(0.0) }

//    val eventhingsPay = listOf(
//        ProfileMenu(
//            icon = R.drawable.ic_balance,
//            label = balance.toRupiah()
//        ),
//        ProfileMenu(
//            icon = R.drawable.ic_top_up,
//            label = stringResource(id = R.string.label_topup)
//        ),
//    )
    val myEventhingsMenus = listOf(
        ProfileMenu(
            icon = R.drawable.ic_purchase,
            label = stringResource(id = R.string.label_purchase)
        ),
        ProfileMenu(
            icon = R.drawable.ic_invoice,
            label = stringResource(id = R.string.label_invoice)
        ),
    )
    val uploadedBusinessMenus = listOf(
        ProfileMenu(
            icon = R.drawable.ic_draft,
            label = stringResource(id = R.string.label_draft)
        ),
        ProfileMenu(
            icon = R.drawable.ic_active,
            label = stringResource(id = R.string.label_active)
        ),
        ProfileMenu(
            icon = R.drawable.ic_archive,
            label = stringResource(id = R.string.label_archive)
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
                onEditProfileClick = onEditProfileClick
            )
//            Spacer(modifier = Modifier.height(16.dp))
//            ProfileMenuSection(
//                title = "Eventh!ngs Pay",
//                menuItems = eventhingsPay,
//                modifier = Modifier.padding(horizontal = 16.dp)
//            )
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
            Spacer(modifier = Modifier.height(20.dp))
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
