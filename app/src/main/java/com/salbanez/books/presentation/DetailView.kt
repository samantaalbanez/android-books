package com.salbanez.books.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.salbanez.books.viewmodel.BooksViewModel

@Composable
fun DetailView(booksViewModel: BooksViewModel, navController: NavController, title: String) {
    Text(text = title, color = Color.Red)
}
