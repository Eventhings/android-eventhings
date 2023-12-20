package com.eventhngs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.eventhngs.data.di.dataModule
import com.eventhngs.di.authModule
import com.eventhngs.domain.di.domainModule
import com.eventhngs.feature_equipment_rental_menu.di.equipmentModule
import com.eventhngs.feature_media_partner_menu.di.mediaPartnerModule
import com.eventhngs.feature_sponsor_menu.di.sponsorModule
import com.eventhngs.navigation.EventhngsNavHost
import com.eventhngs.ui.theme.EventhngsTheme
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@ExperimentalLayoutApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KoinApplication(application = {
                androidContext(applicationContext)
                modules(
                    dataModule,
                    domainModule,
                    authModule,
                    mediaPartnerModule,
                    sponsorModule,
                    equipmentModule
                )
            }) {
                EventhngsTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        EventhngsNavHost()
                    }
                }
            }
        }
    }
}
