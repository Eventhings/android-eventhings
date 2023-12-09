package com.eventhngs.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = "splash-screen")
    object Login : Screen(route = "login")
    object Register : Screen(route = "register")
    object EnterOtp : Screen(route = "enter-otp")
    object ForgotPassword : Screen(route = "forgot-password")
    object ResetPassword : Screen(route = "reset-password")
    object ResetPasswordSuccess : Screen(route = "reset-password-success")
    object Main : Screen(route = "main")
    object AddBusiness : Screen(route = "add-business")
    object AllMenu : Screen(route = "all-menu")
    object MediaPartnerMenu : Screen(route = "media-partner-menu")
    object SponsorMenu : Screen(route = "sponsor-menu")
    object EquipmentRentalMenu : Screen(route = "equipment-rental-menu")
    object EditProfile : Screen(route = "edit-profile")
}