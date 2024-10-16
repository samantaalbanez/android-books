package com.salbanez.books.util

import retrofit2.Response

fun <T> resolveResponse(response: Response<T>) =
    if(response.isSuccessful) response.body() else null
