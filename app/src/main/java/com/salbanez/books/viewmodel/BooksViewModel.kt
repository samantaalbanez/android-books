package com.salbanez.books.viewmodel

import androidx.lifecycle.ViewModel
import com.salbanez.books.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val repository: BooksRepository): ViewModel() {

    private val _booksUiState: MutableStateFlow<BookUiState> = MutableStateFlow(BookUiState.Loading)
    val booksUiState = _booksUiState.asStateFlow()

    init {
        getBooks()
    }

    private fun getBooks() {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                val result = repository.getBooks()
                _booksUiState.value = if(!result.isNullOrEmpty()) {
                    BookUiState.LoadBooks(books = result)
                } else {
                    BookUiState.ShowError
                }
            }
        }
    }
}
