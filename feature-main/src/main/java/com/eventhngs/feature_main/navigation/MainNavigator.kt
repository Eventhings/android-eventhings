package com.eventhngs.feature_main.navigation

interface MainNavigator {
    fun navigateToAllMenuScreen()
    fun navigateToMediaPartnerMenuScreen()
    fun navigateToSponsorMenuScreen()
    fun navigateToEquipmentRentalMenuScreen()
    fun navigateToAddBusinessMenuScreen()
    fun navigateToEditProfileScreen()
}

object EmptyMainNavigator : MainNavigator {
    override fun navigateToAllMenuScreen() {}
    override fun navigateToMediaPartnerMenuScreen() {}
    override fun navigateToSponsorMenuScreen() {}
    override fun navigateToEquipmentRentalMenuScreen() {}
    override fun navigateToAddBusinessMenuScreen() {}
    override fun navigateToEditProfileScreen() {}
}
