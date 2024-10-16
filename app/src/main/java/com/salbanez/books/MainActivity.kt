package com.salbanez.books

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.salbanez.books.navigation.NavManager
import com.salbanez.books.ui.theme.BooksTheme
import com.salbanez.books.viewmodel.BooksViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: BooksViewModel by viewModels()

        setContent {
            BooksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavManager(booksViewModel = viewModel)
                }
            }
        }
    }
}
