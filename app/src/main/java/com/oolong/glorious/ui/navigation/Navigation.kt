package com.oolong.glorious.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oolong.glorious.ui.screens.message.MessageScreen
import com.oolong.glorious.ui.screens.settings.SettingsScreen

@Composable
fun MainNavigation(
  navController: NavHostController,
  modifier: Modifier = Modifier,
) {
  NavHost(navController = navController, startDestination = Screen.MAIN.route) {
    composable(Screen.MAIN.route) { MessageScreen(navController, modifier) }
    composable(Screen.SETTINGS.route) { SettingsScreen(modifier) }
  }
}
