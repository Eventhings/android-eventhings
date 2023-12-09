package com.eventhngs.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.eventhngs.feature_add_business.AddBusinessScreen
import com.eventhngs.feature_all_menu.AllMenuScreen
import com.eventhngs.feature_auth.enterotp.EnterOtpScreen
import com.eventhngs.feature_auth.forgotpassword.ForgotPasswordScreen
import com.eventhngs.feature_auth.login.LoginScreen
import com.eventhngs.feature_auth.register.RegisterScreen
import com.eventhngs.feature_auth.resetpassword.ResetPasswordScreen
import com.eventhngs.feature_auth.resetpasswordsuccess.ResetPasswordSuccessScreen
import com.eventhngs.feature_equipment_rental_menu.EquipmentRentalMenuScreen
import com.eventhngs.feature_main.MainScreen
import com.eventhngs.feature_media_partner_menu.MediaPartnerMenuScreen
import com.eventhngs.feature_profile.editprofile.EditProfileScreen
import com.eventhngs.feature_sponsor_menu.SponsorMenuScreen
import com.eventhngs.splashscreen.SplashScreen

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun EventhngsNavHost(
    startDestination: Screen = Screen.Main,
    navController: NavHostController = rememberNavController()
) {

    val startDestinationRoute = startDestination.route

    NavHost(navController = navController, startDestination = startDestinationRoute) {
        composableWithSlideHorizontalAnimation(Screen.SplashScreen.route) {
            SplashScreen(
                navController
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Login.route) {
            LoginScreen(
                navigateToMainScreen = navController::navigateToMainScreen,
                navigateToRegisterScreen = navController::navigateToRegisterScreen,
                navigateToForgotPasswordScreen = navController::navigateToForgotPasswordScreen
            )
        }
        composableWithSlideHorizontalAnimation(Screen.Register.route) { }
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
        composableWithSlideHorizontalAnimation(Screen.Register.route) {
            RegisterScreen(
               navController
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
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.MediaPartnerMenu.route) {
            MediaPartnerMenuScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.SponsorMenu.route) {
            SponsorMenuScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.EquipmentRentalMenu.route) {
            EquipmentRentalMenuScreen(
                navigateUp = navController::navigateUp
            )
        }
        composableWithSlideHorizontalAnimation(Screen.EditProfile.route) {
            EditProfileScreen(
                navigateUp = navController::navigateUp
            )
        }
    }
}
