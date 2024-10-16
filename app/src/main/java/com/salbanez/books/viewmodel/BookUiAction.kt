package com.salbanez.books.viewmodel

import com.salbanez.books.model.Book

sealed class BookUiAction {

    data object Idle: BookUiAction()
    data class SelectBook(val book: Book): BookUiAction()
}
