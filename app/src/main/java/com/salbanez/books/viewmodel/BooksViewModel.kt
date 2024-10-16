package com.salbanez.books.viewmodel

import androidx.lifecycle.ViewModel
import com.salbanez.books.model.Book
import com.salbanez.books.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val repository: BooksRepository): ViewModel() {

    private val _bookUiState = MutableStateFlow<BookUiState>(BookUiState.Loading)
    val bookUiState: StateFlow<BookUiState> = _bookUiState

    private val _bookUiAction = MutableStateFlow<BookUiAction>(BookUiAction.Idle)
    val bookUiAction: StateFlow<BookUiAction> = _bookUiAction

    private var books: List<Book> = emptyList()

    init {
        getBooks()
    }

    private fun getBooks() {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                books = repository.getBooks() ?: emptyList()
                _bookUiState.value = if(books.isNotEmpty()) {
                    BookUiState.LoadBooks(books = books)
                } else {
                    BookUiState.ShowError
                }
            }
        }
    }

    fun getBook(title: String) {
        val book = books.find { book -> title.equals(book.title) }
        book?.let {
            _bookUiAction.value = BookUiAction.SelectBook(it)
        }
    }
}
