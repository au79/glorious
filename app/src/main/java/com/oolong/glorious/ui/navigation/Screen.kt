package com.oolong.glorious.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.oolong.glorious.R

enum class Screen(
  val route: String,
  @StringRes val displayNameRes: Int,
  @DrawableRes val iconRes: Int?,
  @StringRes val iconDescriptionRes: Int?,
) {
  MAIN("main", R.string.app_name, null, null),
  SETTINGS(
    "settings",
    R.string.settings_screen_display_name,
    R.drawable.settings_icon,
    R.string.settings_icon_description
  );

  companion object {
    infix fun forRoute(value: String?): Screen? = Screen.values().firstOrNull { it.route == value }
  }
}
