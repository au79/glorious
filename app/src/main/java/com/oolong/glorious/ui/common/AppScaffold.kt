package com.oolong.glorious.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oolong.glorious.ui.navigation.GloriousAppBar

@Composable
fun AppScaffold(
  isMainScreen: Boolean,
  displayTitle: String,
  onMenuIconClick: () -> Unit,
  onArrowBackClick: () -> Unit,
  content: @Composable (Modifier) -> Unit,
) {
  Scaffold(
    // Refactor to AppScaffold
    modifier = Modifier.fillMaxSize(),
    topBar = {
      GloriousAppBar(
        title = displayTitle,
        isMainScreen = isMainScreen,
        onClick = if (isMainScreen) onMenuIconClick else onArrowBackClick
      )
    },
  ) { paddingValues ->
    // Padding values passed in take into account any bottom bar.
    content(
      Modifier
        .padding(paddingValues)
        .padding(16.dp))
  }
}

@Preview(name = "Main Screen")
@Composable
fun AppScaffoldMainScreenPreview() {
  AppScaffold(
    isMainScreen = true,
    displayTitle = "Glorious",
    onMenuIconClick = {},
    onArrowBackClick = {}
  ) { modifier ->
    Column(modifier = modifier) {
      Text(text = "Contained by the AppScaffold")
    }
  }
}

@Preview(name = "Other Screen")
@Composable
fun AppScaffoldOtherScreenPreview() {
  AppScaffold(
    isMainScreen = false,
    displayTitle = "Not the Main Screen",
    onMenuIconClick = {},
    onArrowBackClick = {}
  ) { modifier ->
    Column(modifier = modifier) {
      Text(text = "Contained by the AppScaffold")
    }
  }
}
