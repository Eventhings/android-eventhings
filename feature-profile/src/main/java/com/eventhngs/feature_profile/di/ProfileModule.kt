package com.eventhngs.feature_profile.di

import com.eventhngs.feature_profile.editprofile.EditProfileViewModel
import com.eventhngs.feature_profile.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    viewModel { ProfileViewModel(get(), get()) }
    viewModel { EditProfileViewModel(get()) }
}
