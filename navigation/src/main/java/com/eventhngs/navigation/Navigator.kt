package com.eventhngs.navigation

import androidx.navigation.NavHostController
import kotlin.jvm.Throws

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToLoginScreen(
    clearBackStack: Boolean = true,
    from: Screen = Screen.Main
) {
    navigate(Screen.Login.route) {
        if (!clearBackStack) return@navigate
        popUpTo(from.route) {
            inclusive = true
        }
    }
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToRegisterScreen() {
    navigate(Screen.Register.route)
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
fun NavHostController.navigateToMainScreen(
    clearBackStack: Boolean = true,
    from: Screen = Screen.Login
) {
    navigate(Screen.Main.route) {
        if (!clearBackStack) return@navigate
        popUpTo(from.route) {
            inclusive = true
        }
    }
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToAddBusinessScreen() {
    navigate(Screen.AddBusiness.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToAllMenuScreen() {
    navigate(Screen.AllMenu.route)
}

