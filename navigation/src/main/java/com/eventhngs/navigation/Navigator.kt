package com.eventhngs.navigation

import androidx.navigation.NavHostController
import kotlin.jvm.Throws

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToLoginScreen(
    clearBackStack: Boolean = true,
    from: Screen = Screen.Home
) {
    navigate(Screen.Login.route) {
        if (!clearBackStack) return@navigate
        popUpTo(from.route) {
            inclusive = true
        }
    }
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToForgotPasswordScreen() {
    navigate(Screen.ForgotPassword.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToEnterOtpScreen() {
    navigate(Screen.EnterOtp.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToResetPasswordScreen(
    clearBackStack: Boolean = true,
    from: Screen = Screen.EnterOtp
) {
    navigate(Screen.ResetPassword.route) {
        if (!clearBackStack) return@navigate
        popUpTo(from.route) {
            inclusive = true
        }
    }
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToResetPasswordSuccessScreen(
    clearBackStack: Boolean = true,
    from: Screen = Screen.ResetPassword
) {
    navigate(Screen.ResetPasswordSuccess.route) {
        if (!clearBackStack) return@navigate
        popUpTo(from.route) {
            inclusive = true
        }
    }
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToHomeScreen(
    clearBackStack: Boolean = true,
    from: Screen = Screen.Login
) {
    navigate(Screen.Home.route) {
        if (!clearBackStack) return@navigate
        popUpTo(from.route) {
            inclusive = true
        }
    }
}

