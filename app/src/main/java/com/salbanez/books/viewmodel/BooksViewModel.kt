package com.salbanez.books.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salbanez.books.model.Book
import com.salbanez.books.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val repository: BooksRepository): ViewModel() {

    private val _booksMutable = MutableStateFlow<List<Book>>(emptyList())
    val books = _booksMutable.asStateFlow()

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getBooks()
                _booksMutable.value = result ?: emptyList()
            }
        }
    }
}
