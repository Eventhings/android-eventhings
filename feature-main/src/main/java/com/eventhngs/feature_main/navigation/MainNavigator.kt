package com.eventhngs.feature_main.navigation

interface MainNavigator {
    fun navigateToAllMenuScreen()
    fun navigateToMediaPartnerMenuScreen()
    fun navigateToSponsorMenuScreen()
    fun navigateToEquipmentRentalMenuScreen()
    fun navigateToAddBusinessMenuScreen()
    fun navigateToEditProfileScreen(token: String)
    fun navigateToMediaPartnerDetailScreen(id: String)
    fun navigateToSponsorDetailScreen(id: String)
    fun navigateToEquipmentDetailScreen(id: String)
    fun navigateToChatDetailScreen(id: String)
    fun navigateToSettingScreen()
    fun navigateToUploadBusinessScreen()
}

object EmptyMainNavigator : MainNavigator {
    override fun navigateToAllMenuScreen() {}
    override fun navigateToMediaPartnerMenuScreen() {}
    override fun navigateToSponsorMenuScreen() {}
    override fun navigateToEquipmentRentalMenuScreen() {}
    override fun navigateToAddBusinessMenuScreen() {}
    override fun navigateToEditProfileScreen(token: String) {}
    override fun navigateToMediaPartnerDetailScreen(id: String) {}
    override fun navigateToSponsorDetailScreen(id: String) {}
    override fun navigateToEquipmentDetailScreen(id: String) {}
    override fun navigateToChatDetailScreen(id: String) {}
    override fun navigateToSettingScreen() {}
    override fun navigateToUploadBusinessScreen() {}
}
