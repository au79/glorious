package com.oolong.glorious.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oolong.glorious.ui.message.MessageScreen
import com.oolong.glorious.ui.settings.SettingsScreen

@Composable
fun MainNavigation(
  navController: NavHostController,
  modifier: Modifier = Modifier,
) {
  NavHost(navController = navController, startDestination = Screen.MAIN.screenName) {
    composable(Screen.MAIN.screenName) { MessageScreen(navController, modifier) }
    composable(Screen.SETTINGS.screenName) { SettingsScreen(modifier) }
  }
}
