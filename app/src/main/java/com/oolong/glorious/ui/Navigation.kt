package com.oolong.glorious.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.oolong.glorious.ui.message.MessageScreen
import com.oolong.glorious.ui.navigation.Screen
import com.oolong.glorious.ui.settings.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
  val navController = rememberNavController()
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackStackEntry?.destination
  val displayTitle = (Screen forName currentDestination?.route)?.displayName ?: Screen.MAIN.displayName
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(text = displayTitle)
        }
      )
    }
  ) { paddingValues ->
    val modifier = Modifier.padding(paddingValues)
    NavHost(navController = navController, startDestination = Screen.MAIN.screenName) {
      composable(Screen.MAIN.screenName) { MessageScreen(navController, modifier) }
      composable(Screen.SETTINGS.screenName) { SettingsScreen(modifier) }
    }
  }
}
