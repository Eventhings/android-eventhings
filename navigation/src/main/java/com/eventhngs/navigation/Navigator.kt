package com.eventhngs.navigation

import androidx.navigation.NavHostController
import com.eventhngs.feature_main.navigation.MainNavigator
import kotlin.jvm.Throws

class MainNavigator(
    private val navController: NavHostController
) :  MainNavigator {
    override fun navigateToAllMenuScreen() { navController.navigateToAllMenuScreen() }
    override fun navigateToMediaPartnerMenuScreen() { navController.navigateToMediaPartnerMenuScreen() }
    override fun navigateToSponsorMenuScreen() { navController.navigateToSponsorMenuScreen() }
    override fun navigateToEquipmentRentalMenuScreen() { navController.navigateToEquipmentRentalMenuScreen() }
    override fun navigateToAddBusinessMenuScreen() { navController.navigateToAddBusinessScreen() }
    override fun navigateToEditProfileScreen() { navController.navigateToEditProfileScreen() }
    override fun navigateToMediaPartnerDetailScreen(id: String) { navController.navigateToMediaPartnerDetailScreen(id) }
    override fun navigateToSponsorDetailScreen(id: String) { navController.navigateToSponsorDetailScreen(id) }
    override fun navigateToEquipmentDetailScreen(id: String) { navController.navigateToEquipmentDetailScreen(id) }
    override fun navigateToChatDetailScreen(id: String) { navController.navigateToChatDetailScreen(id) }
}

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
fun NavHostController.navigateToAddBusinessScreen() {
    navigate(Screen.AddBusiness.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToAllMenuScreen() {
    navigate(Screen.AllMenu.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToMediaPartnerMenuScreen() {
    navigate(Screen.MediaPartnerMenu.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToSponsorMenuScreen() {
    navigate(Screen.SponsorMenu.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToEquipmentRentalMenuScreen() {
    navigate(Screen.EquipmentRentalMenu.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToEditProfileScreen() {
    navigate(Screen.EditProfile.route)
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToMediaPartnerDetailScreen(id: String) {
    navigate(Screen.MediaPartnerDetail.generateRoute(id))
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToSponsorDetailScreen(id: String) {
    navigate(Screen.SponsorDetail.generateRoute(id))
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToEquipmentDetailScreen(id: String) {
    navigate(Screen.EquipmentDetail.generateRoute(id))
}

@Throws(IllegalArgumentException::class)
fun NavHostController.navigateToChatDetailScreen(id: String) {
    navigate(Screen.ChatDetail.generateRoute(id))
}

