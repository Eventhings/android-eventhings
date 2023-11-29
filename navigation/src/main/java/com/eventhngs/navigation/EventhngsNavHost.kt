package com.eventhngs.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eventhngs.feature_auth.enterotp.EnterOtpScreen
import com.eventhngs.feature_auth.forgotpassword.ForgotPasswordScreen
import com.eventhngs.feature_auth.resetpassword.ResetPasswordScreen
import com.eventhngs.feature_auth.resetpasswordsuccess.ResetPasswordSuccessScreen
import com.eventhngs.feature_home.HomeScreen

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun EventhngsNavHost(
    startDestination: Screen = Screen.Home,
    navController: NavHostController = rememberNavController()
) {

    val startDestinationRoute = startDestination.route

    NavHost(navController = navController, startDestination = startDestinationRoute) {
        composable(Screen.Login.route) { }
        composable(Screen.Register.route) { }
        composable(Screen.EnterOtp.route) {
            EnterOtpScreen()
        }
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen()
        }
        composable(Screen.ResetPassword.route) {
            ResetPasswordScreen()
        }
        composable(Screen.ResetPasswordSuccess.route) {
            ResetPasswordSuccessScreen()
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}
