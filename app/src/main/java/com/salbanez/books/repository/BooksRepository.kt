package com.salbanez.books.repository

import com.salbanez.books.data.remote.BooksApi
import com.salbanez.books.model.Book
import com.salbanez.books.util.resolveResponse
import javax.inject.Inject

class BooksRepository @Inject constructor(private val booksApi: BooksApi) {

    suspend fun getBooks(): List<Book>? = try {
        resolveResponse(booksApi.getBooks())
    } catch (e: Exception) {
        null
    }
}
