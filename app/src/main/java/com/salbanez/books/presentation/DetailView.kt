package com.salbanez.books.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.salbanez.books.presentation.components.InfoComponent
import com.salbanez.books.presentation.components.TopBar
import com.salbanez.books.viewmodel.BookUiAction
import com.salbanez.books.viewmodel.BooksViewModel

@Composable
fun DetailView(navController: NavController, title: String, booksViewModel: BooksViewModel) {
    val uiState = booksViewModel.bookUiAction.collectAsState()
    val state = uiState.value

    TopBar(
        title = title,
        onClick = {
            navController.popBackStack()
        }
    )

    if (state is BookUiAction.SelectBook) {
        InfoComponent(book = state.book)
    }
}
