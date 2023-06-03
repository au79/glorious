package com.oolong.glorious.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GloriousAppBar(
  title: String,
  isMainScreen: Boolean,
  onClick: () -> Unit,
) {
  TopAppBar(
    title = {
      Text(text = title)
    },
    navigationIcon = {
      IconButton(onClick = onClick) {
        Icon(
          imageVector = if (isMainScreen) Icons.Filled.Menu else Icons.Filled.ArrowBack,
          contentDescription = if (isMainScreen) Icons.Filled.Menu.name else Icons.Filled.ArrowBack.name
        )
      }
    }
  )
}

@Preview
@Composable
fun TopAppBarMainScreenPreview() {
  com.oolong.glorious.ui.navigation.GloriousAppBar(
    title = "Main Screen",
    isMainScreen = true
  ) {}
}

@Preview
@Composable
fun TopAppBarOtherScreenPreview() {
  com.oolong.glorious.ui.navigation.GloriousAppBar(
    title = "Other Screen",
    isMainScreen = false
  ) {}
}
