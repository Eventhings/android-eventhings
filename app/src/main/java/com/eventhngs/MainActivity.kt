package com.eventhngs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.eventhngs.data.di.dataModule
import com.eventhngs.domain.di.domainModule
import com.eventhngs.navigation.EventhngsNavHost
import com.eventhngs.ui.theme.EventhngsTheme
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@ExperimentalLayoutApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinApplication(application = {
                androidContext(applicationContext)
                modules(dataModule, domainModule)
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
