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
import com.eventhngs.feature_main.MainScreen
import com.eventhngs.splashscreen.SplashScreen

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun EventhngsNavHost(
    startDestination: Screen = Screen.AllMenu,
    navController: NavHostController = rememberNavController()
) {

    val startDestinationRoute = startDestination.route

    NavHost(navController = navController, startDestination = startDestinationRoute) {
        composableWithSlideAnimation(Screen.SplashScreen.route) {
            SplashScreen(
                navController
            )
        }
        composableWithSlideAnimation(Screen.Login.route) {
            LoginScreen(
                navigateToMainScreen = navController::navigateToMainScreen,
                navigateToRegisterScreen = navController::navigateToRegisterScreen,
                navigateToForgotPasswordScreen = navController::navigateToForgotPasswordScreen
            )
        }
        composableWithSlideAnimation(Screen.Register.route) { }
        composableWithSlideAnimation(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(
                navigateToEnterOtpScreen = navController::navigateToEnterOtpScreen
            )
        }
        composableWithSlideAnimation(Screen.EnterOtp.route) {
            EnterOtpScreen(
                navigateToResetPasswordScreen = navController::navigateToResetPasswordScreen
            )
        }
        composableWithSlideAnimation(Screen.ResetPassword.route) {
            ResetPasswordScreen(
                navigateToResetPasswordSuccessScreen = navController::navigateToResetPasswordSuccessScreen
            )
        }
        composableWithSlideAnimation(Screen.ResetPasswordSuccess.route) {
            ResetPasswordSuccessScreen(
                navigateToLoginScreen = { navController.navigateToLoginScreen(from = Screen.Login) }
            )
        }
        composableWithSlideAnimation(Screen.Register.route) {
            RegisterScreen(
               navController
           )
        }
        composableWithSlideAnimation(Screen.Main.route) {
            MainScreen()
        }
        composableWithSlideAnimation(Screen.AddBusiness.route) {
            AddBusinessScreen()
        }
        composableWithSlideAnimation(Screen.AllMenu.route) {
            AllMenuScreen()
        }
    }
}
