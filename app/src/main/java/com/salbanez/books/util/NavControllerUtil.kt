package com.salbanez.books.util

import androidx.navigation.NavBackStackEntry

const val NAV_ID = "title"
const val NAV_DEFAULT_ID = ""

fun NavBackStackEntry?.toId() =
    this?.arguments?.getString(NAV_ID) ?: NAV_DEFAULT_ID
