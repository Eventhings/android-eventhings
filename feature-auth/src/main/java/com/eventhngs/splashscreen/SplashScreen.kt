package com.eventhngs.splashscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eventhngs.feature_auth.R
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: SplashScreenViewModel = koinViewModel(),
    navigateToLoginScreen: () -> Unit,
    navigateToMainScreen: () -> Unit
) {

    val isLogging by viewModel.isLogging.collectAsStateWithLifecycle(initialValue = false)

    LaunchedEffect(key1 = Unit){
        delay(2000L)
        if (isLogging) {
            navigateToMainScreen()
            return@LaunchedEffect
        }
        navigateToLoginScreen()
    }

    Scaffold(modifier = modifier) {
        Box(
            modifier = Modifier
                .navigationBarsPadding()
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.bg_splash_screen),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.drawable.eventhings_logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(282.dp)
                    .height(109.dp)
            )
        }
    }

}