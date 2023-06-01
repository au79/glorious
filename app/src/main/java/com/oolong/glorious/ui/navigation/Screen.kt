package com.oolong.glorious.ui.navigation

enum class Screen(val screenName: String, val displayName: String) {
  MAIN("main", "Glorious"),
  SETTINGS("settings", "Settings");

  companion object {
    infix fun forName(value: String?): Screen? = Screen.values().firstOrNull { it.screenName == value }
  }
}
