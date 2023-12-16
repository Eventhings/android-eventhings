package com.eventhngs.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
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
import com.eventhngs.feature_equipment_rental_menu.EquipmentRentalMenuScreen
import com.eventhngs.feature_equipment_rental_menu.detail.DetailEquipmentScreen
import com.eventhngs.feature_main.MainScreen
import com.eventhngs.feature_media_partner_menu.MediaPartnerMenuScreen
import com.eventhngs.feature_media_partner_menu.detail.DetailMediaPartnerScreen
import com.eventhngs.feature_profile.editprofile.EditProfileScreen
import com.eventhngs.feature_sponsor_menu.SponsorMenuScreen
import com.eventhngs.feature_sponsor_menu.detail.DetailSponsorScreen
import com.eventhngs.splashscreen.SplashScreen

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun EventhngsNavHost(
    startDestination: Screen = Screen.SplashScreen,
    navController: NavHostController = rememberNavController()
) {

    val startDestinationRoute = startDestination.route
//    val startDestinationRoute = Screen.ChatDetail.generateRoute(1)

    NavHost(navController = navController, startDestination = startDestinationRoute) {
        composableWithSlideHorizontalAnimation(Screen.SplashScreen.route) {
            SplashScreen(
                navigateToNextScreen = { navController.navigateToLoginScreen(from = Screen.SplashScreen) }
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
            RegisterScreen(
                navController
            )
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
        composableWithSlideHorizontalAnimation(Screen.EditProfile.route) {
            EditProfileScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.MediaPartnerDetail.route,
            arguments = listOf(
                navArgument(Screen.MEDIA_PARTNER_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            val mediaPartnerId = it.arguments?.getInt(Screen.MEDIA_PARTNER_ID) ?: 0
            DetailMediaPartnerScreen(
                navigateUp = navController::navigateUp,
                mediaPartnerId = mediaPartnerId
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.SponsorDetail.route,
            arguments = listOf(
                navArgument(Screen.SPONSOR_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            val sponsorId = it.arguments?.getInt(Screen.SPONSOR_ID) ?: 0
            DetailSponsorScreen(
                navigateUp = navController::navigateUp,
                sponsorId = sponsorId
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.EquipmentDetail.route,
            arguments = listOf(
                navArgument(Screen.EQUIPMENT_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            val equipmentId = it.arguments?.getInt(Screen.EQUIPMENT_ID) ?: 0
            DetailEquipmentScreen(
                navigateUp = navController::navigateUp,
                equipmentId = equipmentId
            )
        }
        composableWithSlideHorizontalAnimation(
            route = Screen.ChatDetail.route,
            arguments = listOf(
                navArgument(Screen.CHAT_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            val chatId = it.arguments?.getInt(Screen.CHAT_ID) ?: 0
            DetailChatScreen(
                navigateUp = navController::navigateUp,
                chatId = chatId
            )
        }

    }
}
