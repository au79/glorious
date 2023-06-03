package com.oolong.glorious.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.oolong.glorious.ui.common.AppScaffold
import com.oolong.glorious.ui.navigation.AppNavigationDrawerContent
import com.oolong.glorious.ui.navigation.MainNavigation
import com.oolong.glorious.ui.navigation.Screen
import com.oolong.glorious.ui.theme.GloriousTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


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
          val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
          val coroutineScope = rememberCoroutineScope()

          ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
              AppNavigationDrawerContent()
            }
          ) {
            AppScaffold(
              isMainScreen = currentDestination?.route == Screen.MAIN.screenName,
              displayTitle = displayTitle,
              onMenuIconClick = {
                coroutineScope.launch {
                  drawerState.open()
                }
              },
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
}
