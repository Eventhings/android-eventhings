package com.eventhngs.feature_main.navigation

interface MainNavigator {
    fun navigateToAllMenuScreen()
    fun navigateToMediaPartnerMenuScreen()
    fun navigateToSponsorMenuScreen()
    fun navigateToEquipmentRentalMenuScreen()
    fun navigateToAddBusinessMenuScreen()
    fun navigateToEditProfileScreen()
    fun navigateToMediaPartnerDetailScreen(id: Int)
    fun navigateToSponsorDetailScreen(id: Int)
    fun navigateToEquipmentDetailScreen(id: Int)
    fun navigateToChatDetailScreen(id: Int)
}

object EmptyMainNavigator : MainNavigator {
    override fun navigateToAllMenuScreen() {}
    override fun navigateToMediaPartnerMenuScreen() {}
    override fun navigateToSponsorMenuScreen() {}
    override fun navigateToEquipmentRentalMenuScreen() {}
    override fun navigateToAddBusinessMenuScreen() {}
    override fun navigateToEditProfileScreen() {}
    override fun navigateToMediaPartnerDetailScreen(id: Int) {}
    override fun navigateToSponsorDetailScreen(id: Int) {}
    override fun navigateToEquipmentDetailScreen(id: Int) {}
    override fun navigateToChatDetailScreen(id: Int) {}
}
