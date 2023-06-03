package com.oolong.glorious.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.oolong.glorious.ui.common.AppScaffold
import com.oolong.glorious.ui.message.MessageScreen
import com.oolong.glorious.ui.navigation.MainNavigation
import com.oolong.glorious.ui.navigation.Screen
import com.oolong.glorious.ui.settings.SettingsScreen
import dagger.hilt.android.AndroidEntryPoint
import com.oolong.glorious.ui.theme.GloriousTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      GloriousTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          val navController = rememberNavController()
          val navBackStackEntry by navController.currentBackStackEntryAsState()
          val currentDestination = navBackStackEntry?.destination
          val displayTitle =
            (Screen forName currentDestination?.route)?.displayName ?: Screen.MAIN.displayName

          AppScaffold(
            isMainScreen = currentDestination?.route == Screen.MAIN.screenName,
            displayTitle = displayTitle,
            onMenuIconClick = { /* Open MND */ },
            onArrowBackClick = { navController.navigateUp() }
          ) { modifier ->
            MainNavigation(
              navController = navController,
              modifier = modifier,
            )
          }
        }
      }
    }
  }
}
