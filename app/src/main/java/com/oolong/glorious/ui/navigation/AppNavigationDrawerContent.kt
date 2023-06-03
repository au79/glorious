package com.oolong.glorious.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun AppNavigationDrawerContent() {
  ModalDrawerSheet {
    Surface(color = MaterialTheme.colorScheme.background) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(text = "DRAWER")
      }
    }
  }
}
