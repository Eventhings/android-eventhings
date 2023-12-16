package com.eventhngs.navigation

sealed class Screen(val route: String) {

    companion object {
        const val MEDIA_PARTNER_ID = "media_partner_id"
        const val SPONSOR_ID = "sponsor_id"
        const val EQUIPMENT_ID = "equipment_id"
        const val CHAT_ID = "equipment_id"
    }

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
    object MediaPartnerDetail : Screen(route = "media-partner-detail/{$MEDIA_PARTNER_ID}") {
        fun generateRoute(mediaPartnerId: Int): String {
            return "media-partner-detail/$mediaPartnerId"
        }
    }
    object SponsorDetail : Screen(route = "sponsor-detail/{$SPONSOR_ID}") {
        fun generateRoute(sponsorId: Int): String {
            return "sponsor-detail/$sponsorId"
        }
    }
    object EquipmentDetail : Screen(route = "equipment-detail/{$EQUIPMENT_ID}") {
        fun generateRoute(equipmentId: Int): String {
            return "equipment-detail/$equipmentId"
        }
    }
    object ChatDetail : Screen(route = "chat-detail/{$CHAT_ID}") {
        fun generateRoute(chatId: Int): String {
            return "chat-detail/$chatId"
        }
    }
}