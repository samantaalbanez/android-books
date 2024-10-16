package com.salbanez.books.data.remote

import com.salbanez.books.model.Book
import retrofit2.Response
import retrofit2.http.GET

interface BooksApi {

    @GET("a10c8de5-c7ee-476a-999e-4ceaf9b8c2c1")
    suspend fun getBooks(): Response<List<Book>>
}
