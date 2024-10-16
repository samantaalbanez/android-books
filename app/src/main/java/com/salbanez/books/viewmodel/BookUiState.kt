package com.salbanez.books.viewmodel

import com.salbanez.books.model.Book

sealed class BookUiState {

    data class LoadBooks(val books: List<Book>): BookUiState()
    data object Loading: BookUiState()
    data object ShowError: BookUiState()
}
