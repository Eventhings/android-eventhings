package com.eventhngs.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = "splash-screen")
    object Login : Screen(route = "login")
    object Register : Screen(route = "register")
    object EnterOtp : Screen(route = "enter-otp")
    object ForgotPassword : Screen(route = "forgot-password")
    object ResetPassword : Screen(route = "reset-password")
    object ResetPasswordSuccess : Screen(route = "reset-password-success")
    object Home : Screen(route = "home")
    object Chat : Screen(route = "chat")
    object Notification : Screen(route = "notification")
    object Profile : Screen(route = "profile")
}