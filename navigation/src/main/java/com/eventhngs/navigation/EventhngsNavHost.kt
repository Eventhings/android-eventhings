package com.eventhngs.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eventhngs.feature_add_business.AddBusinessScreen
import com.eventhngs.feature_all_menu.AllMenuScreen
import com.eventhngs.feature_auth.enterotp.EnterOtpScreen
import com.eventhngs.feature_auth.forgotpassword.ForgotPasswordScreen
import com.eventhngs.feature_auth.login.LoginScreen
import com.eventhngs.feature_auth.register.RegisterScreen
import com.eventhngs.feature_auth.resetpassword.ResetPasswordScreen
import com.eventhngs.feature_auth.resetpasswordsuccess.ResetPasswordSuccessScreen
import com.eventhngs.feature_chat.detail.DetailChatScreen
import com.eventhngs.feature_equipment_rental_menu.list.EquipmentRentalMenuScreen
import com.eventhngs.feature_equipment_rental_menu.detail.DetailEquipmentScreen
import com.eventhngs.feature_main.MainScreen
import com.eventhngs.feature_media_partner_menu.list.MediaPartnerMenuScreen
import com.eventhngs.feature_media_partner_menu.detail.DetailMediaPartnerScreen
import com.eventhngs.feature_profile.editprofile.EditProfileScreen
import com.eventhngs.feature_sponsor_menu.list.SponsorMenuScreen
import com.eventhngs.feature_sponsor_menu.detail.DetailSponsorScreen
import com.eventhngs.splashscreen.SplashScreen

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun EventhngsNavHost(
    startDestination: Screen = Screen.SplashScreen,
    navController: NavHostController = rememberNavController()
) {

    val startDestinationRoute = startDestination.route
//    val startDestinationRoute = Screen.MediaPartnerDetail.generateRoute("002ad707-8006-4c7f-9d98-19e0650cff0d")

    NavHost(navController = navController, startDestination = startDestinationRoute) {
        composableWithSlideHorizontalAnimation(Screen.SplashScreen.route) {
            SplashScreen(
                navigateToLoginScreen = { navController.navigateToLoginScreen(from = Screen.SplashScreen) },
                navigateToMainScreen = { navController.navigateToMainScreen(from = Screen.SplashScreen) }
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Login.route) {
            LoginScreen(
                navigateToMainScreen = navController::navigateToMainScreen,
                navigateToRegisterScreen = navController::navigateToRegisterScreen,
                navigateToForgotPasswordScreen = navController::navigateToForgotPasswordScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Register.route) {
            RegisterScreen()
        }
        composableWithSlideHorizontalAnimation(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(
                navigateToEnterOtpScreen = navController::navigateToEnterOtpScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.EnterOtp.route) {
            EnterOtpScreen(
                navigateToResetPasswordScreen = navController::navigateToResetPasswordScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.ResetPassword.route) {
            ResetPasswordScreen(
                navigateToResetPasswordSuccessScreen = navController::navigateToResetPasswordSuccessScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.ResetPasswordSuccess.route) {
            ResetPasswordSuccessScreen(
                navigateToLoginScreen = { navController.navigateToLoginScreen(from = Screen.Login) }
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Main.route) {
            val mainNavigator = MainNavigator(navController)
            MainScreen(
                mainNavigator = mainNavigator
            )
        }
        composableWithSlideVerticalAnimation(Screen.AddBusiness.route) {
            AddBusinessScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.AllMenu.route) {
            AllMenuScreen(
                navigateUp = navController::navigateUp,
                navigateToMediaPartnerDetail = navController::navigateToMediaPartnerDetailScreen,
                navigateToSponsorDetailScreen = navController::navigateToSponsorDetailScreen,
                navigateToEquipmentDetail = navController::navigateToEquipmentDetailScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.MediaPartnerMenu.route) {
            MediaPartnerMenuScreen(
                navigateUp = navController::navigateUp,
                navigateToMediaPartnerDetail = navController::navigateToMediaPartnerDetailScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.SponsorMenu.route) {
            SponsorMenuScreen(
                navigateUp = navController::navigateUp,
                navigateToSponsorDetailScreen = navController::navigateToSponsorDetailScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.EquipmentRentalMenu.route) {
            EquipmentRentalMenuScreen(
                navigateUp = navController::navigateUp,
                navigateToEquipmentDetail = navController::navigateToEquipmentDetailScreen
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.EditProfile.route,
            arguments = listOf(
                navArgument(Screen.TOKEN) {
                    type = NavType.StringType
                }
            )
        ) {
            val token = it.arguments?.getString(Screen.TOKEN) ?: ""
            EditProfileScreen(
                navigateUp = navController::navigateUp,
                token = token
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.MediaPartnerDetail.route,
            arguments = listOf(
                navArgument(Screen.MEDIA_PARTNER_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            val mediaPartnerId = it.arguments?.getString(Screen.MEDIA_PARTNER_ID) ?: ""
            DetailMediaPartnerScreen(
                navigateUp = navController::navigateUp,
                mediaPartnerId = mediaPartnerId,
                navigateToMediaPartnerMenuScreen = navController::navigateToMediaPartnerMenuScreen
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.SponsorDetail.route,
            arguments = listOf(
                navArgument(Screen.SPONSOR_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            val sponsorId = it.arguments?.getString(Screen.SPONSOR_ID) ?: ""
            DetailSponsorScreen(
                navigateUp = navController::navigateUp,
                sponsorId = sponsorId,
                navigateToSponsorMenuScreen = navController::navigateToSponsorMenuScreen
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.EquipmentDetail.route,
            arguments = listOf(
                navArgument(Screen.EQUIPMENT_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            val equipmentId = it.arguments?.getString(Screen.EQUIPMENT_ID) ?: ""
            DetailEquipmentScreen(
                navigateUp = navController::navigateUp,
                equipmentId = equipmentId,
                navigateToEquipmentMenuScreen = navController::navigateToEquipmentRentalMenuScreen
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.ChatDetail.route,
            arguments = listOf(
                navArgument(Screen.CHAT_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            val chatId = it.arguments?.getString(Screen.CHAT_ID) ?: ""
            DetailChatScreen(
                navigateUp = navController::navigateUp,
                chatId = chatId
            )
        }
    }
}
