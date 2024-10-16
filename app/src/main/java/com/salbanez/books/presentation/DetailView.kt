package com.salbanez.books.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.salbanez.books.presentation.components.TopBar

@Composable
fun DetailView(navController: NavController, title: String) {
    TopBar(title = title, onClick = {
        navController.popBackStack()
    })
}
