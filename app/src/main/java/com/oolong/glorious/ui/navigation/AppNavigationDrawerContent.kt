package com.oolong.glorious.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.oolong.glorious.BuildConfig
import com.oolong.glorious.R
import com.oolong.glorious.ui.theme.GloriousTheme

@Composable
fun AppNavigationDrawerContent(
  drawerItems: List<Screen>,
  onClick: (Screen) -> Unit,
) {
  ModalDrawerSheet(
    drawerContainerColor = MaterialTheme.colorScheme.background,
    drawerContentColor = MaterialTheme.colorScheme.primary
  ) {
    Surface(
      color = Color.Transparent
    ) {
      Column(
        horizontalAlignment = Alignment.Start
      ) {
        val sidePadding = Modifier.padding(
          start = dimensionResource(id = R.dimen.nav_drawer_item_side_padding),
          end = dimensionResource(id = R.dimen.nav_drawer_item_side_padding),
        )
        val itemPadding = sidePadding.padding(
          bottom = dimensionResource(id = R.dimen.nav_drawer_item_bottom_padding)
        )
        Text(
          style = MaterialTheme.typography.headlineSmall,
          text = stringResource(id = R.string.app_name_long),
          modifier = sidePadding.padding(
            top = dimensionResource(id = R.dimen.nav_drawer_title_top_padding),
            bottom = dimensionResource(id = R.dimen.nav_drawer_item_bottom_padding),
          )
        )
        Text(
          style = MaterialTheme.typography.bodyMedium,
          text = stringResource(
            id = R.string.version_string,
            BuildConfig.VERSION_NAME,
            BuildConfig.VERSION_CODE
          ),
          modifier = sidePadding.padding(
            bottom = dimensionResource(id = R.dimen.nav_drawer_item_bottom_padding),
          )
        )
        Divider(
          modifier = itemPadding
        )
        drawerItems.map { screen ->
          Row() {
            NavigationDrawerItem(
              label = {
                Text(text = stringResource(id = screen.displayNameRes))
              },
              icon = {
                Icon(
                  painter = painterResource(id = R.drawable.settings_icon),
                  contentDescription = ""
                )
              },
              selected = false,
              onClick = { onClick(screen) },
              modifier = itemPadding,
            )

          }
        }
      }
    }
  }
}

@Preview
@Composable
fun AppNavigationDrawerContentPreview() {
  GloriousTheme(darkTheme = true) {
    AppNavigationDrawerContent(
      drawerItems = listOf(Screen.SETTINGS),
      onClick = { /* Do nothing in preview. */ }
    )
  }
}