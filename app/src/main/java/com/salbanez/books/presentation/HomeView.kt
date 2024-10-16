package com.salbanez.books.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.salbanez.books.presentation.components.ContentHomeView
import com.salbanez.books.presentation.components.TopBar
import com.salbanez.books.viewmodel.BooksViewModel

@Composable
fun HomeView(booksViewModel: BooksViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "Books")
        }
    ) {
        ContentHomeView(
            booksViewModel = booksViewModel,
            padding = it,
            navController = navController
        )
    }
}
