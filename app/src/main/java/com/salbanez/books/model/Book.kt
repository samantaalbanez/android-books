package com.salbanez.books.model

data class Book(
    val author: String,
    val country: String,
    val language: String,
    val pages: Int,
    val title: String,
    val year: Long,
    val link: String,
    val imageLink: String
)
